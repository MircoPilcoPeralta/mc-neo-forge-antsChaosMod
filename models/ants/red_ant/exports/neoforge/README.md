# Red Ant: Models and Animations

Asset package for NeoForge 26.3.0.97. **It does not modify the existing `AntExplorer` entity, its registration, attributes, AI or the main mod class.** There is no automatic installer.

## Edit in Blockbench

Open `../../blockbench/red_ant.bbmodel` and select **Animate**.

| Clip | Length | Loop | Visual purpose |
|---|---:|---|---|
| `idle` | 2 s | Yes | Antenna movements and subtle breathing |
| `walk` | 0.8 s | Yes | Alternating movement of the four supporting legs |
| `grab` | 0.6 s | No; hold last pose | Close the two front legs |
| `carry` | 1.6 s | Yes | Maintain the grasping pose |
| `release` | 0.6 s | No; hold last pose | Return to the resting pose |

The rig includes six independent elbows, antennae, head, thorax and abdomen. The empty `agarre_item` bone marks an item attachment point; **this package does not implement item transfers or item rendering**. Existing rig bone names remain unchanged so animation bindings stay valid.

The model retains its 24 cubes and is one block tall at rest. Animated poses can extend slightly beyond those bounds.

## Export

From the repository root:

```sh
python3 models/tools/export_red_ant.py
```

The exporter preserves hand-edited Blockbench keyframes and regenerates:

- `src/main/java/.../client/RedAntGeometry.java`: the `ModelPart` hierarchy, pivots and per-face UVs.
- `src/main/resources/assets/antsplusantsequalschaos/neoforge/animations/entity/red_ant/`: native NeoForge animation JSON files.
- `src/main/resources/assets/antsplusantsequalschaos/textures/entity/red_ant.png`: the exported texture.

Supported tracks use numeric rotation or position keyframes and linear or Catmull-Rom interpolation. Expressions, split keyframes and unsupported channels stop the export to prevent an incorrect conversion.

`--reset-animations` replaces manual animation edits with the five default clips. Use it only to reset them.

## Connect to existing client code

`RedAntModel.java` and `RedAntRenderState.java` are an optional model adapter and visual state, independent of the entity implementation. They are delivered here rather than copied into the mod's source tree.

The renderer responsible for `AntExplorer` can use these assets and populate `phase` (`IDLE=0`, `GRAB=1`, `CARRY=2`, `RELEASE=3`) and `actionTicks` (elapsed gesture time in ticks). `walkAnimationPos`, `walkAnimationSpeed` and `ageInTicks` are standard render-state fields. The adapter applies the clips and rebinds them after resource reloads.

Resource identifiers use English names: animation IDs are `antsplusantsequalschaos:red_ant/<clip>` and the texture is `antsplusantsequalschaos:textures/entity/red_ant.png`.

Deciding when to grab, carry or release belongs to the existing entity code. `translateToGrip` only transforms the attachment point and does not change inventory or behavior.

## Validation

The JSON files were parsed with NeoForge 26.3.0.97's actual codec and bound to the exported geometry. Multiple poses, bone references and loop boundaries were checked. The three Java model files were compiled with the project's dependencies. In-game verification remains pending connection to the existing renderer.
