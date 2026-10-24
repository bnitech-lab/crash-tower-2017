# CrashTower (2017)

An unfinished prototype of a real-time card battle game for Android, written by a student team in the summer of 2017. It was inspired by Clash Royale. There is no battle server: the real-time online part was never written, and development stopped at the prototype stage.

**Not affiliated with Supercell.** Clash Royale and its card names are the property of Supercell. This project is not endorsed by or connected to Supercell.

**The card art has been removed.** The original project used card pictures and a battleground screenshot taken from Clash Royale, so every picture under `res/drawable` was removed from this copy. Only the default Android launcher icons remain. Some card names in the code (for example the giant, the barbarian and P.E.K.K.A) still follow Clash Royale's card names.

Shared as a record of a student team project. No licence is granted.

## What the code does

- **Main screen:** a Story button that opens the battle screen, a My Page button and an options button.
- **Battle screen** (`BattleActivity`, `BattleGroundView`): five card buttons and a battlefield drawn on a custom `View`. Tap a card, then tap the field, and that card's unit appears where you tapped. Each unit runs on its own thread, moves diagonally and bounces off the edges of the field. Each unit has a square sensor area, drawn as a red outline; when another unit's centre enters it, that unit is pushed back. Unit size, HP, attack and speed come from `CardInfo` (seven cards and an empty slot). There is no damage, no tower (`Tower` is an empty class) and no win or loss yet.
- **My Page:** a grid of six cards and four deck tabs. Tapping a card opens a popup with its name and an Equip button, which places the card in one of the six slots of the selected deck.
- **Options:** a sound toggle, ID and password fields, and Log in, Sign up and Remember ID controls that do nothing yet.
- **Result popup** (`SingleResult`): crown animation, an EXP bar and gold totals from fixed test values. It is registered in the manifest but nothing opens it. `MultiResult` and `ResultActivity` are only layouts.
- `ItemTouchHelperCallback`, `ItemTouchHelperListener` and `LongClickListener` (drag and swipe helpers) are not used anywhere.

## Facts

| | |
|---|---|
| Year | 2017 (July) |
| Team | At least 3 students |
| Dawn's part | The battle screen: `activity/BattleActivity.java`, `view/BattleGroundView.java`, `model/Unit.java`, `model/Tower.java` and `data/CardInfo.java`. According to the files' author comments, other team members wrote the My Page, options and result code; a few files, including `MainActivity` and `MypageActivity`, had no author record. |
| Language | Java |
| Original toolchain | Android Studio 2.3 era: Android Gradle Plugin 2.3.3, Gradle 3.3, `compileSdkVersion 26`, build tools 26.0.0, `minSdkVersion 24` |
| Libraries | Android Support Library 26.0.0-alpha1 (appcompat-v7, recyclerview-v7, cardview-v7, design), ConstraintLayout 1.0.2, from `jcenter()` |

## Building it today

This has not been tried, and it will not build as published because the pictures the code loads are missing. A likely route:

1. Upgrade the Android Gradle Plugin and Gradle, replace `jcenter()` with `google()` and `mavenCentral()`, change `compile` to `implementation`, and add a `namespace` to `app/build.gradle`.
2. Migrate from the Support Library to AndroidX (Android Studio has a Migrate to AndroidX action).
3. The Gradle wrapper jar is not included. Run `gradle wrapper` with a current Gradle to recreate `gradle/wrapper/gradle-wrapper.jar` before using `./gradlew`.
4. Supply your own images in `app/src/main/res/drawable` under the names the code uses: `baba`, `battle_ground`, `bone`, `card_background`, `ccr_giant`, `cr_archer`, `cr_cavalry`, `cr_swordman`, `crown`, `crown1`, `option`, `pekka`.

Known gaps in the code itself: the "Level up" button in the card popup calls `chexlvup`, which does not exist, so tapping it would crash.

## What was removed and why

| Removed | Why |
|---|---|
| All 14 pictures in `app/src/main/res/drawable` | Card pictures and a battleground screenshot from Clash Royale (Supercell), plus a settings icon of unknown origin |
| `gradle/wrapper/gradle-wrapper.jar` | Binary file; can be regenerated (see above) |

Kept: the ten launcher icons under `res/mipmap-*`, which are the unchanged Android Studio template icons.

Changes to the code:

- The IDE-generated author comment at the top of 12 Java files was deleted, because it named the authors' accounts.
- Two placeholder player IDs (in `MainActivity` and `SingleResult`) were changed to `PLAYER` and `player`, because the originals were a team member's nickname.
- Three unused intent-filter action names in `AndroidManifest.xml` were renamed from another project's package prefix to `com.bbp.crashtower.intentfilter.*`.
- A comment in `app/proguard-rules.pro` that held a local Windows user path now reads `${sdk.dir}`.

Nothing else was changed.

## Status

Unfinished prototype from 2017. Development stopped; not maintained. No battle server, no combat rules, and it does not build without new images.
