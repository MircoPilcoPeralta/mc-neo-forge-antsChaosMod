# Mod Models

Use one folder per model. Ant designs belong in `ants/`; unrelated designs are kept in `other/`. File and folder names must be English, lowercase `snake_case`.

```text
models/
├── ants/
│   └── red_ant/
│       ├── README.md
│       ├── blockbench/       # Editable project and animation tracks
│       ├── textures/        # Source PNG files
│       ├── previews/        # Model images
│       ├── exports/
│       │   └── neoforge/    # Exported JSON, texture and Java model
│       └── validation/     # Asset checks
├── other/
│   └── plastic_soldier_player/
│       ├── blockbench/
│       ├── textures/
│       └── previews/
├── tools/
│   └── export_red_ant.py
└── logs/                   # Existing tool logs
```

## Open the current ant

Open [red_ant.bbmodel](ants/red_ant/blockbench/red_ant.bbmodel) in Blockbench. Select **Animate**, choose `idle`, `walk`, `grab`, `carry` or `release`, then press Play.

## Add another ant

Create `ants/<model_name>/`, for example `ants/black_ant/` or `ants/queen_ant/`. Use the same `blockbench/`, `textures/`, `previews/`, `exports/neoforge/` and `validation/` layout where applicable.

Editable animations remain in the `.bbmodel`. Generated JSON files belong in the export folder. Export folders are deliverables, **not the mod's active `src/` directory**. Asset work must not modify `AntExplorer`, its registry, attributes or behavior.

## Export the red ant

From the repository root:

```sh
python3 models/tools/export_red_ant.py
```

From `models/`:

```sh
python3 tools/export_red_ant.py
```

Paths are resolved relative to the script, so the working directory does not matter. This exporter is specific to the red ant and preserves hand-edited animation tracks. See the [NeoForge export instructions](ants/red_ant/exports/neoforge/README.md).
