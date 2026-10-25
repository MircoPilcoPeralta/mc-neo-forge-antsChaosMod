# Red Ant

A red Minecraft-style ant, one block tall in its rest pose, with four supporting legs and two front legs positioned to grasp items.

- **Edit and animate:** `blockbench/red_ant.bbmodel`.
- **Source texture:** `textures/red_ant.png`, also embedded in the Blockbench project.
- **Preview:** `previews/red_ant_preview.png`.
- **Animation tracks:** `idle`, `walk`, `grab`, `carry` and `release`, stored in the `.bbmodel`.
- **NeoForge assets:** `exports/neoforge/`, with separate integration notes.
- **Validation:** `validation/AntAssetCheck.java`, which checks clips through NeoForge's actual animation codec.

From `models/`, run `python3 tools/export_red_ant.py` to refresh the export. Edited animation tracks are preserved. `--reset-animations` explicitly replaces them with the five default clips.

The existing rig bone names are retained to preserve animation bindings. The empty `agarre_item` bone is an item attachment reference. Entity behavior and item handling belong to `AntExplorer` and are not implemented by these assets.
