# CS611 – Assignment 4

# Legends of Valor 

- Rithvik Doshi and Huy Phan
- [rithvik@bu.edu](mailto:rithvik@bu.edu) and [hphan6@bu.edu](mailto:hphan6@bu.edu)
- U98773385 and U99944177

## Files
- Data Files - contains object attributes
  - Armory.ldf
  - Dragons.ldf
  - Exoskeletons.ldf
  - FireSpells.ldf
  - IceSpells.ldf
  - LightningSpells.ldf
  - Paladins.ldf
  - Potions.ldf
  - Sorcerers.ldf
  - Spirits.ldf
  - Warriors.ldf
  - Weaponry.ldf


- Game Files
  - Item.java - class to store item data
    - Armor.java - a class that represents an armor item
    - Potion.java (consumable) - a class that represents a potion item
    - Weapon.java - a class that represents a weapon item
    - Spell.java (consumable) - a class that represents a spell item
      - FireSpell.java - a class that represents a fire spell item
      - IceSpell.java - a class that represents an ice spell item
      - LightningSpell.java - a class that represents a lightning spell item
  - Legend.java - an abstract superclass that represents a character in each game
    - Hero.java - a class that represents a hero player
      - HeroInventory.java - a class that represents a hero's inventory
      - Paladin.java - a class that represents a paladin hero
      - Sorcerer.java - a class that represents a sorcerer hero
      - Warrior.java - a class that represents a warrior hero
    - Monster.java - a class that represents a monster player
      - Dragon.java - a class that represents a dragon monster
      - Exoskeleton.java - a class that represents an exoskeleton monster
      - Spirit.java - a class that represents a spirit monster
  - Space.java - abstract space object
    - Common.java - a class that represents a common space
    - Inaccessible.java - a class that represents an inaccessible space
    - Market.java - a class that represents a market space
    - Nexus.java - a class that represents a nexus space
    - Plain.java - a class that represents a plain space
    - Cave.java - a class that represents a cave space
    - Bush.java - a class that represents a bush space
    - Koulou.java - a class that represents a koulou space
    - LOV_Space.java - class to store LOV space data
    - HeroAffectSpace.java - class to store hero affect space data
  - Game.java - abstract superclass for games
    - LMH_Game - Game object for LMH
    - LOV_Game - Game object for LOV
  - Map.java - abstract superclass for maps
    - LMH_Map.java - Map object for LMH
    - LOV_Map.java - Map object for LOV
  - Main.java - main class to run game


- Interfaces
  - Accessible.java - interface for accessible objects
    - LMH_Accessible.java - interface for accessible objects in LMH (extends accessible)
    - LOV_Accessible.java - interface for accessible objects in LOV (extends accessible)
  - Consumable.java - interface for consumable objects
  - UsesHeroes.java - interface for Game objects that use heroes
  - AttributeAffectable.java - interface for special spaces that increase specific hero attributes


- Helper Classes
  - LegendStatus.java - enum for legend status
  - Color.java - a class that contains ANSI escape codes used for colored printing in terminal
  - DataList.java - class to store data
  - DataLoader.java - class to load data
  - DataMap.java - class to store data
  - GameEngine.java - class to handle game I/O
  - GameCenter.java - class to initialize all games
  - ArtMessages.java - class to store custom ASCII art messages


- MISC Files
  - README.md - this file
  - LegendsUML.png - UML diagram of project

### Java Dependencies:
- Java 8
  - java.io.BufferedReader
  - java.io.FileReader
  - java.io.IOException
  - java.util.stream.Collectors
  - java.util.ArrayList
  - java.io.File
  - java.io.FileNotFoundException
  - java.nio.file.Path
  - java.nio.file.Paths
  - java.util.Scanner
  - java.util.Collections 
  - java.util.TreeMap

## Game Instructions and Information

### 1. The world of Legends of Valor

Legends of Valor is a MOBA-like game. The player will control a team of 3 heroes who will attempt to fight their way through to the monsters; Nexus. Heroes win if any of them reach the monsters' Nexus. Heroes lose if vice versa.

#### Controls

Use W/A/S/D to move the heroes around the map. The heroes can only move one space at a time. The heroes can only move to a space that is adjacent to their current position.

- Q: Quit
- T: Teleport
- R: Recall
- Z: Attack
- E: Change equipment
- P: Use potion
- X: Cast spell
- M: Enter Market
- I: Info

### 2. Spaces

LOV is played in an 8x8 grid of spaces. The grid is split into 3 lanes, each separated by a column of inaccessible and impassible spaces. There are 6 different types of spaces:

- Nexus (marked by an 'N'): Both heroes and monsters have a Nexus. Heroes win if any of them reach the monsters' Nexus. Heroes lose if vice versa.
- Inaccessible (marked by an 'X'): Heroes and monsters cannot enter these spaces
- Plain (marked by a 'P'): These spaces have no special properties
- Bush (marked by a 'B'): Bushes increase hero's dexterity by 10%
- Cave (marked by a 'C'): Caves increase hero's agility by 10%
- Koulou (marked by a 'K'): Koulous increase hero's strength by 10%

### 3. Gameplay

- The goal of each team is to have one of their members reach the Nexus of the other team
- Before the game begins, the player chooses the three heroes that will be used and which of the
  three lanes that hero will start in
- Heroes and Monsters spawn in their respective Nexus, and move towards the other team's Nexus
- One hero and monster per lane
- The game is played in rounds. A round consists of the heroes’ turn followed by the monsters’
  turn.

#### Valid Hero Actions

- Change Weapon or Armor
- Use a Potion
- Attack
- Cast a Spell
- Move
- Teleport
- Recall

### 4. About Heroes and Monsters

Each hero has a name, a level with experience points, hit points, mana points, a strength, dexterity and agility value, starting money and an inventory that can hold up to 10 items.

In addition to this, you can choose heroes of different classes. The classes are:
- Warriors, who are given higher strength and agility.
- Sorcerers, who are given higher dexterity and agility.
- Paladins, who are given higher strength and dexterity.

A monster has a name, a level, hit points, a damage, defense and dodge value.

You can read up on the kinds of monsters in the provided text files. There are three kinds of monsters:
- Dragons, who are given higher damage
- Exoskeletons, who are given higher defense
- Spirits, who are given higher dodge

### 5. The Market

The market exists and can only be accessed in the Heroes' Nexus. To access the market, the hero must be in a Nexus space. Consequently, press 'M' on the home screen at the beginning of the turn.

Follow the market instructions to buy or sell an item. You can only buy or sell one item per turn. You can only buy items that you have enough money for. You can only sell items that you have in your inventory. If you sell an item, you will get back half of its purchase price as money.

### 6. Items

There are four kinds of items in the game:

1. Weapons: used to attack a monster.
2. Armor: used to defend against an attack from a monster.
3. Potions: used to restore a certain hero statistic.
4. Spells: consume mana points and are used to attack a monster and reduce a certain monster statistic.
    1. Ice spells reduce the defense of the target
    2. Fire spells reduce the defense of the target
    3. Lightning spells reduce the dodge chance of the target

Keep in mind that in order to use a weapon or armor, you must equip it at the beginning of a battle.
Potions and spells are consumable items. Potions can only be drunk once, and spells can only be cast three times. Make sure that you have enough MP to cast a spell, as it costs a certain amount to be able to cast each time!

These items can be bought at a market. For some items, you may have to be at a certain level to be able to use them, so be careful!

### 7. Stat Calculations

Spell damage = `spell_base_damage + (hero dexterity/10000) * spell_base_damage`

Starting HP for Legend: `100 * starting level`

At every new level, Hero's HP is set to `100 * level` and MP is doubled

Hero's attack damage (with a weapon, hero cannot attack without a weapon) = `(strength + weapon damage) * 0.4`

Monster's attack damage = `monster damage * 0.005`

Legend dodge chance = `0.001 * legend dodgeAmt`

Exp needed to level up: `10 * current level`

Players and monsters never regain health/mp during a battle.

Hero gold gain = `current gold += 100 * hero level`

Hero exp gain = `current EXP += 2 * hero level`

Hero hp/mp gain = `baseHP or baseMP stat * 1.1`

### 8. GLHF!

## Scalability and Extendability

We designed and built the foundation of these games to allow for easy scalability and extendability. We have implemented the following features to allow for this: Abstract classes such as Legend, Monster, and Item, as well as interfaces such as Consumable, LMH_Accessible, and LOV_Accessible. These features allow for easy implementation of new features and classes, as well as easy modification of existing features and classes. For example, if we wanted to add a new class of spells, we would simply create a new class that extends Spell, and implement the abstract methods. 

## Notes

1. Files to be parsed should be stored in ConfigFiles, for parser class to read class
2. Bonus features/implementations:
   1. \# of  monsters that are generated is random, but will usually be close to the \# of players playing. This is given by the formula:
      1. ``Math.random() < (0.8 - (Math.pow(0.4, heroes.size())))``
   2. Use of color to highlight important text and information.
      1. Created a class to encapsulate color codes for ANSI escape sequences.
      2. Created a static method that takes in a string and a color, and returns a string with the color code at the beginning and the reset code at the end.
   3. Use of interfaces to specify specialized behavior for certain classes.
      1. Consumable interface for potions and spells
      2. LMH_Accessible + LOV_Accessible interface for market and common spaces
3. 

## How to compile and run

1. Make sure that the text config files are located in ``src/data/`` and all other files in ``src``.
2. Load src into a new Intellij project.
   1. If you choose to compile and run from the command line, make sure that you are in the ``src`` directory.
   2. Note that it will be necessary to change all the file paths referenced in the codebase to be direct paths to the files on your machine, as opposed to relative paths.
3. Compile and run the Main class
   1. If you choose to run from command line, run: ``javac Main.java -Xlint:unchecked`` and then ``java Main.java``
4. Follow the instructions on the screen to play the game!

## Input/Output Example

```
88888888888888888888888888888888888888888888888888888888888888888888888
88.._|      | `-.  | `.  -_-_ _-_  _-  _- -_ -  .'|   |.'|     |  _..88
88   `-.._  |    |`!  |`.  -_ -__ -_ _- _-_-  .'  |.;'   |   _.!-'|  88
88      | `-!._  |  `;!  ;. _______________ ,'| .-' |   _!.i'     |  88
88..__  |     |`-!._ | `.| |_______________||."'|  _!.;'   |     _|..88
88   |``"..__ |    |`";.| i|_|MMMMMMMMMMM|_|'| _!-|   |   _|..-|'    88
88   |      |``--..|_ | `;!|l|MMoMMMMoMMM|1|.'j   |_..!-'|     |     88
88   |      |    |   |`-,!_|_|MMMMP'YMMMM|_||.!-;'  |    |     |     88
88___|______|____!.,.!,.!,!|d|MMMo * loMM|p|,!,.!.,.!..__|_____|_____88
88      |     |    |  |  | |_|MMMMb,dMMMM|_|| |   |   |    |      |  88
88      |     |    |..!-;'i|r|MPYMoMMMMoM|r| |`-..|   |    |      |  88
88      |    _!.-j'  | _!,"|_|M<>MMMMoMMM|_||!._|  `i-!.._ |      |  88
88     _!.-'|    | _."|  !;|1|MbdMMoMMMMM|l|`.| `-._|    |``-.._  |  88
88..-i'     |  _.''|  !-| !|_|MMMoMMMMoMM|_|.|`-. | ``._ |     |``"..88
88   |      |.|    |.|  !| |u|MoMMMMoMMMM|n||`. |`!   | `".    |     88
88   |  _.-'  |  .'  |.' |/|_|MMMMoMMMMoM|_|! |`!  `,.|    |-._|     88
88  _!"'|     !.'|  .'| .'|[@]MMMMMMMMMMM[@] \|  `. | `._  |   `-._  88
88-'    |   .'   |.|  |/| /                 \|`.  |`!    |.|      |`-88
88      |_.'|   .' | .' |/                   \  \ |  `.  | `._-Lee|  88
88     .'   | .'   |/|  /                     \ |`!   |`.|    `.  |  88
88  _.'     !'|   .' | /                       \|  `  |  `.    |`.|  88
88 WELCOME TO THE PARTY 8888888888888888888888888888888888888888(FL)888

Which game would you like to play? 

1. Legends of Monsters and Heroes
2. Legends Of Valor
Choose an option: 2

H@b                 ,H@@______________________________________________________
H@@EEEEEEEEEEEEEEEEEEEH@@                                                    /
H@@EEEEEEEEEEEEEEEEEEEH@@            WELCOME TO LEGENDS OF VALOR            /
H@@EEEEEEEEEEEEEEEEEEEH@@__________________________________________________/
H@P                  `H@@
                      T@

Welcome to Legends of Valor! Do you want to see the instructions? (Y/N)
1. Y
2. N
Choose an option: 1
# Game Instructions and Information

## 1. The world of Legends of Valor

Legends of Valor is a MOBA-like game. The player will control a team of 3 heroes who will attempt to fight their way through to the monsters; Nexus. Heroes win if any of them reach the monsters' Nexus. Heroes lose if vice versa. 

#### Controls

Use W/A/S/D to move the heroes around the map. The heroes can only move one space at a time. The heroes can only move to a space that is adjacent to their current position.

- Q: Quit
- T: Teleport
- R: Recall
- Z: Attack
- E: Change equipment
- P: Use potion
- X: Cast spell
- M: Enter Market
- I: Info

## 2. Spaces

LOV is played in an 8x8 grid of spaces. The grid is split into 3 lanes, each separated by a column of inaccessible and impassible spaces. There are 6 different types of spaces:

- Nexus (marked by an 'N'): Both heroes and monsters have a Nexus. Heroes win if any of them reach the monsters' Nexus. Heroes lose if vice versa.
- Inaccessible (marked by an 'X'): Heroes and monsters cannot enter these spaces
- Plain (marked by a 'P'): These spaces have no special properties
- Bush (marked by a 'B'): Bushes increase hero's dexterity by 10%
- Cave (marked by a 'C'): Caves increase hero's agility by 10%
- Koulou (marked by a 'K'): Koulous increase hero's strength by 10%



## 3. Gameplay

- The goal of each team is to have one of their members reach the Nexus of the other team
- Before the game begins, the player chooses the three heroes that will be used and which of the
  three lanes that hero will start in
- Heroes and Monsters spawn in their respective Nexus, and move towards the other team's Nexus
- One hero and monster per lane
- The game is played in rounds. A round consists of the heroes’ turn followed by the monsters’
  turn. 

#### Valid Hero Actions

- Change Weapon or Armor
- Use a Potion
- Attack
- Cast a Spell
- Move
- Teleport
- Recall

## 4. About Heroes and Monsters

Each hero has a name, a level with experience points, hit points, mana points, a strength, dexterity and agility value, starting money and an inventory that can hold up to 10 items.

In addition to this, you can choose heroes of different classes. The classes are:
- Warriors, who are given higher strength and agility.
- Sorcerers, who are given higher dexterity and agility.
- Paladins, who are given higher strength and dexterity.

A monster has a name, a level, hit points, a damage, defense and dodge value.

You can read up on the kinds of monsters in the provided text files. There are three kinds of monsters:
- Dragons, who are given higher damage
- Exoskeletons, who are given higher defense
- Spirits, who are given higher dodge

## 5. The Market

The market exists and can only be accessed in the Heroes' Nexus. To access the market, the hero must be in a Nexus space. Consequently, press 'M' on the home screen at the beginning of the turn.

Follow the market instructions to buy or sell an item. You can only buy or sell one item per turn. You can only buy items that you have enough money for. You can only sell items that you have in your inventory. If you sell an item, you will get back half of its purchase price as money.

## 6. Items

There are four kinds of items in the game:

1. Weapons: used to attack a monster.
2. Armor: used to defend against an attack from a monster.
3. Potions: used to restore a certain hero statistic.
4. Spells: consume mana points and are used to attack a monster and reduce a certain monster statistic.
    1. Ice spells reduce the defense of the target
    2. Fire spells reduce the defense of the target
    3. Lightning spells reduce the dodge chance of the target

Keep in mind that in order to use a weapon or armor, you must equip it at the beginning of a battle.
Potions and spells are consumable items. Potions can only be drunk once, and spells can only be cast three times. Make sure that you have enough MP to cast a spell, as it costs a certain amount to be able to cast each time!

These items can be bought at a market. For some items, you may have to be at a certain level to be able to use them, so be careful!

## 7. Stat Calculations

Spell damage = `spell_base_damage + (hero dexterity/10000) * spell_base_damage`

Starting HP for Legend: `100 * starting level`

At every new level, Hero's HP is set to `100 * level` and MP is doubled

Hero's attack damage (with a weapon, hero cannot attack without a weapon) = `(strength + weapon damage) * 0.4`

Monster's attack damage = `monster damage * 0.005`

Legend dodge chance = `0.001 * legend dodgeAmt`

Exp needed to level up: `10 * current level`

Players and monsters never regain health/mp during a battle.

Hero gold gain = `current gold += 100 * hero level`

Hero exp gain = `current EXP += 2 * hero level`

Hero hp/mp gain = `baseHP or baseMP stat * 1.1`

## 8. GLHF!

________________________________________________________________________________

Select a map to play on: 
Generating map...
Heroes:

Monsters:

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| B | P | X | P | P | X | C | P |
	+---+---+---+---+---+---+---+---+
 2	| P | B | X | P | K | X | P | C |
	+---+---+---+---+---+---+---+---+
 3	| P | C | X | B | P | X | C | B |
	+---+---+---+---+---+---+---+---+
 4	| P | P | X | B | B | X | P | K |
	+---+---+---+---+---+---+---+---+
 5	| P | K | X | K | P | X | K | P |
	+---+---+---+---+---+---+---+---+
 6	| P | B | X | K | P | X | C | P |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
Confirm this map? (1 for Yes, 2 for No)
1. Y
2. N
Choose an option: 2
Generating map...
Heroes:

Monsters:

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
Confirm this map? (1 for Yes, 2 for No)
1. Y
2. N
Choose an option: 1
Paladins:
	Amaryllis_Astra:
		agility: 500
		dexterity: 500
		mana: 500
		starting experience: 5
		starting money: 2500
		strength: 500
	Caliber_Heist:
		agility: 400
		dexterity: 400
		mana: 400
		starting experience: 8
		starting money: 2500
		strength: 400
	Garl_Glittergold:
		agility: 500
		dexterity: 400
		mana: 100
		starting experience: 5
		starting money: 2500
		strength: 600
	Parzival:
		agility: 650
		dexterity: 700
		mana: 300
		starting experience: 7
		starting money: 2500
		strength: 750
	Sehanine_Moonbow:
		agility: 700
		dexterity: 700
		mana: 300
		starting experience: 7
		starting money: 2500
		strength: 750
	Skoraeus_Stonebones:
		agility: 600
		dexterity: 350
		mana: 250
		starting experience: 4
		starting money: 2500
		strength: 650
Sorcerers:
	Kalabar:
		agility: 400
		dexterity: 600
		mana: 800
		starting experience: 6
		starting money: 2500
		strength: 850
	Reign_Havoc:
		agility: 800
		dexterity: 800
		mana: 800
		starting experience: 8
		starting money: 2500
		strength: 800
	Reverie_Ashels:
		agility: 700
		dexterity: 400
		mana: 900
		starting experience: 7
		starting money: 2500
		strength: 800
	Rillifane_Rallathil:
		agility: 450
		dexterity: 500
		mana: 1300
		starting experience: 9
		starting money: 2500
		strength: 750
	Segojan_Earthcaller:
		agility: 500
		dexterity: 650
		mana: 900
		starting experience: 5
		starting money: 2500
		strength: 800
	Skye_Soar:
		agility: 400
		dexterity: 500
		mana: 1000
		starting experience: 5
		starting money: 2500
		strength: 700
Warriors:
	Eunoia_Cyn:
		agility: 800
		dexterity: 600
		mana: 400
		starting experience: 6
		starting money: 2500
		strength: 700
	Flandal_Steelskin:
		agility: 650
		dexterity: 700
		mana: 200
		starting experience: 7
		starting money: 2500
		strength: 750
	Gaerdal_Ironhand:
		agility: 500
		dexterity: 600
		mana: 100
		starting experience: 7
		starting money: 1354
		strength: 700
	Muamman_Duathall:
		agility: 500
		dexterity: 750
		mana: 300
		starting experience: 6
		starting money: 2546
		strength: 900
	Sehanine_Monnbow:
		agility: 800
		dexterity: 500
		mana: 600
		starting experience: 8
		starting money: 2500
		strength: 700
	Undefeated_Yoj:
		agility: 400
		dexterity: 700
		mana: 400
		starting experience: 7
		starting money: 2500
		strength: 800

Hero 1, choose your class and hero!
1. Paladins
2. Sorcerers
3. Warriors
Choose an option: 1
1. Amaryllis_Astra
2. Caliber_Heist
3. Garl_Glittergold
4. Parzival
5. Sehanine_Moonbow
6. Skoraeus_Stonebones
Choose an option: 1
You have chosen: Amaryllis_Astra
Hero 2, choose your class and hero!
1. Paladins
2. Sorcerers
3. Warriors
Choose an option: 2
1. Kalabar
2. Reign_Havoc
3. Reverie_Ashels
4. Rillifane_Rallathil
5. Segojan_Earthcaller
6. Skye_Soar
Choose an option: 2
You have chosen: Reign_Havoc
Hero 3, choose your class and hero!
1. Paladins
2. Sorcerers
3. Warriors
Choose an option: 3
1. Eunoia_Cyn
2. Flandal_Steelskin
3. Gaerdal_Ironhand
4. Muamman_Duathall
5. Sehanine_Monnbow
6. Undefeated_Yoj
Choose an option: 3
You have chosen: Gaerdal_Ironhand
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
D-Maleficent (Dragon) @ [0, 1]
Casper (Spirit) @ [0, 7]
Andromalius (Spirit) @ [0, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [7, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: m
Entering market...
Armory:
	Breastplate:
		cost: 350
		damage reduction: 600
		required level: 3
	Full_Body_Armor:
		cost: 1000
		damage reduction: 1100
		required level: 8
	Guardian_Angel:
		cost: 1000
		damage reduction: 1000
		required level: 10
	Platinum_Shield:
		cost: 150
		damage reduction: 200
		required level: 1
	Wizard_Shield:
		cost: 1200
		damage reduction: 1500
		required level: 10
FireSpells:
	Breath_of_Fire:
		cost: 350
		damage: 450
		mana cost: 100
		required level: 1
	Flame_Tornado:
		cost: 700
		damage: 850
		mana cost: 300
		required level: 4
	Heat_Wave:
		cost: 450
		damage: 600
		mana cost: 150
		required level: 2
	Hell_Storm:
		cost: 600
		damage: 950
		mana cost: 600
		required level: 3
	Lava_Comet:
		cost: 800
		damage: 1000
		mana cost: 550
		required level: 7
IceSpells:
	Arctic_Storm:
		cost: 700
		damage: 800
		mana cost: 300
		required level: 6
	Frost_Blizzard:
		cost: 750
		damage: 850
		mana cost: 350
		required level: 5
	Ice_Blade:
		cost: 250
		damage: 450
		mana cost: 100
		required level: 1
	Snow_Cannon:
		cost: 500
		damage: 650
		mana cost: 250
		required level: 2
LightningSpells:
	Electric_Arrows:
		cost: 550
		damage: 650
		mana cost: 200
		required level: 5
	Lightning_Dagger:
		cost: 400
		damage: 500
		mana cost: 150
		required level: 1
	Spark_Needles:
		cost: 500
		damage: 600
		mana cost: 200
		required level: 2
	Thunder_Blast:
		cost: 750
		damage: 950
		mana cost: 400
		required level: 4
Potions:
	Ambrosia:
		attribute affected: All_Health/Mana/Strength/Dexterity/Defense/Agility
		attribute increase: 150
		cost: 1000
		required level: 8
	Healing_Potion:
		attribute affected: Health
		attribute increase: 100
		cost: 250
		required level: 1
	Luck_Elixir:
		attribute affected: Agility
		attribute increase: 65
		cost: 500
		required level: 4
	Magic_Potion:
		attribute affected: Mana
		attribute increase: 100
		cost: 350
		required level: 2
	Mermaid_Tears:
		attribute affected: Health/Mana/Strength/Agility
		attribute increase: 100
		cost: 850
		required level: 5
	Strength_Potion:
		attribute affected: Strength
		attribute increase: 75
		cost: 200
		required level: 1
Weaponry:
	Axe:
		cost: 550
		damage: 850
		required hands: 1
		required level: 5
	Bow:
		cost: 300
		damage: 500
		required hands: 2
		required level: 2
	Dagger:
		cost: 200
		damage: 250
		required hands: 1
		required level: 1
	Scythe:
		cost: 1000
		damage: 1100
		required hands: 2
		required level: 6
	Sword:
		cost: 500
		damage: 800
		required hands: 1
		required level: 1
	TSwords:
		cost: 1400
		damage: 1600
		required hands: 2
		required level: 8

-----------------------------------------
Name: Amaryllis_Astra
Level: 5
HP: 500
Class: Paladins
MP: 500
Strength: 600
Agility: 500
Dexterity: 600
Money: 2500
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (0/10):
Empty!
-----------------------------------------

Amaryllis_Astra, would you like to buy or sell items?
1. Buy
2. Sell
3. Skip
Choose an option: 1
Select an item class to buy from: 
1. Potions
2. Weaponry
3. Armory
4. FireSpells
5. IceSpells
6. LightningSpells
Choose an option: 2
Select an item to buy: 
1. Axe
2. Bow
3. Dagger
4. Scythe
5. Sword
6. TSwords
Choose an option: 5
You have selected: Sword
Buy Sword for 500? Amaryllis_Astra has 2500 gold.
1. Yes
2. No
Choose an option: 1
Successfully bought Sword
-----------------------------------------
Name: Amaryllis_Astra
Level: 5
HP: 500
Class: Paladins
MP: 500
Strength: 600
Agility: 500
Dexterity: 600
Money: 2000
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (1/10):
Sword:
	Purchase Price: 500
	Level: 1
	Damage: 800

-----------------------------------------

Amaryllis_Astra, would you like to continue shopping?
1. Yes
2. No
Choose an option: 2
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
D-Maleficent (Dragon) @ [0, 1]
Casper (Spirit) @ [0, 7]
Andromalius (Spirit) @ [0, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [7, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: e
Changing equipment...
What would you like to equip?
1. Weapon
2. Armor
Choose an option: 1
Sword:
	Purchase Price: 500
	Level: 1
	Damage: 800

1. Sword
Choose an option: 1
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
D-Maleficent (Dragon) @ [0, 1]
Casper (Spirit) @ [0, 7]
Andromalius (Spirit) @ [0, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [7, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: m
Entering market...
Armory:
	Breastplate:
		cost: 350
		damage reduction: 600
		required level: 3
	Full_Body_Armor:
		cost: 1000
		damage reduction: 1100
		required level: 8
	Guardian_Angel:
		cost: 1000
		damage reduction: 1000
		required level: 10
	Platinum_Shield:
		cost: 150
		damage reduction: 200
		required level: 1
	Wizard_Shield:
		cost: 1200
		damage reduction: 1500
		required level: 10
FireSpells:
	Breath_of_Fire:
		cost: 350
		damage: 450
		mana cost: 100
		required level: 1
	Flame_Tornado:
		cost: 700
		damage: 850
		mana cost: 300
		required level: 4
	Heat_Wave:
		cost: 450
		damage: 600
		mana cost: 150
		required level: 2
	Hell_Storm:
		cost: 600
		damage: 950
		mana cost: 600
		required level: 3
	Lava_Comet:
		cost: 800
		damage: 1000
		mana cost: 550
		required level: 7
IceSpells:
	Arctic_Storm:
		cost: 700
		damage: 800
		mana cost: 300
		required level: 6
	Frost_Blizzard:
		cost: 750
		damage: 850
		mana cost: 350
		required level: 5
	Ice_Blade:
		cost: 250
		damage: 450
		mana cost: 100
		required level: 1
	Snow_Cannon:
		cost: 500
		damage: 650
		mana cost: 250
		required level: 2
LightningSpells:
	Electric_Arrows:
		cost: 550
		damage: 650
		mana cost: 200
		required level: 5
	Lightning_Dagger:
		cost: 400
		damage: 500
		mana cost: 150
		required level: 1
	Spark_Needles:
		cost: 500
		damage: 600
		mana cost: 200
		required level: 2
	Thunder_Blast:
		cost: 750
		damage: 950
		mana cost: 400
		required level: 4
Potions:
	Ambrosia:
		attribute affected: All_Health/Mana/Strength/Dexterity/Defense/Agility
		attribute increase: 150
		cost: 1000
		required level: 8
	Healing_Potion:
		attribute affected: Health
		attribute increase: 100
		cost: 250
		required level: 1
	Luck_Elixir:
		attribute affected: Agility
		attribute increase: 65
		cost: 500
		required level: 4
	Magic_Potion:
		attribute affected: Mana
		attribute increase: 100
		cost: 350
		required level: 2
	Mermaid_Tears:
		attribute affected: Health/Mana/Strength/Agility
		attribute increase: 100
		cost: 850
		required level: 5
	Strength_Potion:
		attribute affected: Strength
		attribute increase: 75
		cost: 200
		required level: 1
Weaponry:
	Axe:
		cost: 550
		damage: 850
		required hands: 1
		required level: 5
	Bow:
		cost: 300
		damage: 500
		required hands: 2
		required level: 2
	Dagger:
		cost: 200
		damage: 250
		required hands: 1
		required level: 1
	Scythe:
		cost: 1000
		damage: 1100
		required hands: 2
		required level: 6
	Sword:
		cost: 500
		damage: 800
		required hands: 1
		required level: 1
	TSwords:
		cost: 1400
		damage: 1600
		required hands: 2
		required level: 8

-----------------------------------------
Name: Reign_Havoc
Level: 8
HP: 800
Class: Sorcerers
MP: 800
Strength: 800
Agility: 960
Dexterity: 960
Money: 2500
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (0/10):
Empty!
-----------------------------------------

Reign_Havoc, would you like to buy or sell items?
1. Buy
2. Sell
3. Skip
Choose an option: 2
Select an item to sell: 
You have no items to sell.
-----------------------------------------
Name: Reign_Havoc
Level: 8
HP: 800
Class: Sorcerers
MP: 800
Strength: 800
Agility: 960
Dexterity: 960
Money: 2500
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (0/10):
Empty!
-----------------------------------------

Reign_Havoc, would you like to continue shopping?
1. Yes
2. No
Choose an option: 1
Armory:
	Breastplate:
		cost: 350
		damage reduction: 600
		required level: 3
	Full_Body_Armor:
		cost: 1000
		damage reduction: 1100
		required level: 8
	Guardian_Angel:
		cost: 1000
		damage reduction: 1000
		required level: 10
	Platinum_Shield:
		cost: 150
		damage reduction: 200
		required level: 1
	Wizard_Shield:
		cost: 1200
		damage reduction: 1500
		required level: 10
FireSpells:
	Breath_of_Fire:
		cost: 350
		damage: 450
		mana cost: 100
		required level: 1
	Flame_Tornado:
		cost: 700
		damage: 850
		mana cost: 300
		required level: 4
	Heat_Wave:
		cost: 450
		damage: 600
		mana cost: 150
		required level: 2
	Hell_Storm:
		cost: 600
		damage: 950
		mana cost: 600
		required level: 3
	Lava_Comet:
		cost: 800
		damage: 1000
		mana cost: 550
		required level: 7
IceSpells:
	Arctic_Storm:
		cost: 700
		damage: 800
		mana cost: 300
		required level: 6
	Frost_Blizzard:
		cost: 750
		damage: 850
		mana cost: 350
		required level: 5
	Ice_Blade:
		cost: 250
		damage: 450
		mana cost: 100
		required level: 1
	Snow_Cannon:
		cost: 500
		damage: 650
		mana cost: 250
		required level: 2
LightningSpells:
	Electric_Arrows:
		cost: 550
		damage: 650
		mana cost: 200
		required level: 5
	Lightning_Dagger:
		cost: 400
		damage: 500
		mana cost: 150
		required level: 1
	Spark_Needles:
		cost: 500
		damage: 600
		mana cost: 200
		required level: 2
	Thunder_Blast:
		cost: 750
		damage: 950
		mana cost: 400
		required level: 4
Potions:
	Ambrosia:
		attribute affected: All_Health/Mana/Strength/Dexterity/Defense/Agility
		attribute increase: 150
		cost: 1000
		required level: 8
	Healing_Potion:
		attribute affected: Health
		attribute increase: 100
		cost: 250
		required level: 1
	Luck_Elixir:
		attribute affected: Agility
		attribute increase: 65
		cost: 500
		required level: 4
	Magic_Potion:
		attribute affected: Mana
		attribute increase: 100
		cost: 350
		required level: 2
	Mermaid_Tears:
		attribute affected: Health/Mana/Strength/Agility
		attribute increase: 100
		cost: 850
		required level: 5
	Strength_Potion:
		attribute affected: Strength
		attribute increase: 75
		cost: 200
		required level: 1
Weaponry:
	Axe:
		cost: 550
		damage: 850
		required hands: 1
		required level: 5
	Bow:
		cost: 300
		damage: 500
		required hands: 2
		required level: 2
	Dagger:
		cost: 200
		damage: 250
		required hands: 1
		required level: 1
	Scythe:
		cost: 1000
		damage: 1100
		required hands: 2
		required level: 6
	Sword:
		cost: 500
		damage: 800
		required hands: 1
		required level: 1
	TSwords:
		cost: 1400
		damage: 1600
		required hands: 2
		required level: 8

-----------------------------------------
Name: Reign_Havoc
Level: 8
HP: 800
Class: Sorcerers
MP: 800
Strength: 800
Agility: 960
Dexterity: 960
Money: 2500
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (0/10):
Empty!
-----------------------------------------

Reign_Havoc, would you like to buy or sell items?
1. Buy
2. Sell
3. Skip
Choose an option: 1
Select an item class to buy from: 
1. Potions
2. Weaponry
3. Armory
4. FireSpells
5. IceSpells
6. LightningSpells
Choose an option: 1
Select an item to buy: 
1. Ambrosia
2. Healing_Potion
3. Luck_Elixir
4. Magic_Potion
5. Mermaid_Tears
6. Strength_Potion
Choose an option: 2
You have selected: Healing_Potion
Buy Healing_Potion for 250? Reign_Havoc has 2500 gold.
1. Yes
2. No
Choose an option: 1
Successfully bought Healing_Potion
-----------------------------------------
Name: Reign_Havoc
Level: 8
HP: 800
Class: Sorcerers
MP: 800
Strength: 800
Agility: 960
Dexterity: 960
Money: 2250
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (1/10):
Healing_Potion:
	Purchase Price: 250
	Level: 1
	Effect: Health
	Change: 100

-----------------------------------------

Reign_Havoc, would you like to continue shopping?
1. Yes
2. No
Choose an option: 2
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
D-Maleficent (Dragon) @ [0, 1]
Casper (Spirit) @ [0, 7]
Andromalius (Spirit) @ [0, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [7, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: f
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
D-Maleficent (Dragon) @ [0, 1]
Casper (Spirit) @ [0, 7]
Andromalius (Spirit) @ [0, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [7, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: m
Entering market...
Armory:
	Breastplate:
		cost: 350
		damage reduction: 600
		required level: 3
	Full_Body_Armor:
		cost: 1000
		damage reduction: 1100
		required level: 8
	Guardian_Angel:
		cost: 1000
		damage reduction: 1000
		required level: 10
	Platinum_Shield:
		cost: 150
		damage reduction: 200
		required level: 1
	Wizard_Shield:
		cost: 1200
		damage reduction: 1500
		required level: 10
FireSpells:
	Breath_of_Fire:
		cost: 350
		damage: 450
		mana cost: 100
		required level: 1
	Flame_Tornado:
		cost: 700
		damage: 850
		mana cost: 300
		required level: 4
	Heat_Wave:
		cost: 450
		damage: 600
		mana cost: 150
		required level: 2
	Hell_Storm:
		cost: 600
		damage: 950
		mana cost: 600
		required level: 3
	Lava_Comet:
		cost: 800
		damage: 1000
		mana cost: 550
		required level: 7
IceSpells:
	Arctic_Storm:
		cost: 700
		damage: 800
		mana cost: 300
		required level: 6
	Frost_Blizzard:
		cost: 750
		damage: 850
		mana cost: 350
		required level: 5
	Ice_Blade:
		cost: 250
		damage: 450
		mana cost: 100
		required level: 1
	Snow_Cannon:
		cost: 500
		damage: 650
		mana cost: 250
		required level: 2
LightningSpells:
	Electric_Arrows:
		cost: 550
		damage: 650
		mana cost: 200
		required level: 5
	Lightning_Dagger:
		cost: 400
		damage: 500
		mana cost: 150
		required level: 1
	Spark_Needles:
		cost: 500
		damage: 600
		mana cost: 200
		required level: 2
	Thunder_Blast:
		cost: 750
		damage: 950
		mana cost: 400
		required level: 4
Potions:
	Ambrosia:
		attribute affected: All_Health/Mana/Strength/Dexterity/Defense/Agility
		attribute increase: 150
		cost: 1000
		required level: 8
	Healing_Potion:
		attribute affected: Health
		attribute increase: 100
		cost: 250
		required level: 1
	Luck_Elixir:
		attribute affected: Agility
		attribute increase: 65
		cost: 500
		required level: 4
	Magic_Potion:
		attribute affected: Mana
		attribute increase: 100
		cost: 350
		required level: 2
	Mermaid_Tears:
		attribute affected: Health/Mana/Strength/Agility
		attribute increase: 100
		cost: 850
		required level: 5
	Strength_Potion:
		attribute affected: Strength
		attribute increase: 75
		cost: 200
		required level: 1
Weaponry:
	Axe:
		cost: 550
		damage: 850
		required hands: 1
		required level: 5
	Bow:
		cost: 300
		damage: 500
		required hands: 2
		required level: 2
	Dagger:
		cost: 200
		damage: 250
		required hands: 1
		required level: 1
	Scythe:
		cost: 1000
		damage: 1100
		required hands: 2
		required level: 6
	Sword:
		cost: 500
		damage: 800
		required hands: 1
		required level: 1
	TSwords:
		cost: 1400
		damage: 1600
		required hands: 2
		required level: 8

-----------------------------------------
Name: Gaerdal_Ironhand
Level: 7
HP: 700
Class: Warriors
MP: 100
Strength: 840
Agility: 600
Dexterity: 600
Money: 1354
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (0/10):
Empty!
-----------------------------------------

Gaerdal_Ironhand, would you like to buy or sell items?
1. Buy
2. Sell
3. Skip
Choose an option: 1
Select an item class to buy from: 
1. Potions
2. Weaponry
3. Armory
4. FireSpells
5. IceSpells
6. LightningSpells
Choose an option: 4
Select an item to buy: 
1. Breath_of_Fire
2. Flame_Tornado
3. Heat_Wave
4. Hell_Storm
5. Lava_Comet
Choose an option: 1
You have selected: Breath_of_Fire
Buy Breath_of_Fire for 350? Gaerdal_Ironhand has 1354 gold.
1. Yes
2. No
Choose an option: 1
Successfully bought Breath_of_Fire
-----------------------------------------
Name: Gaerdal_Ironhand
Level: 7
HP: 700
Class: Warriors
MP: 100
Strength: 840
Agility: 600
Dexterity: 600
Money: 1004
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (1/10):
Breath_of_Fire:
	Purchase Price: 350
	Level: 1
	Type: Fire
	Mana Cost: 100
	Uses left: 3
	Damage: 450

-----------------------------------------

Gaerdal_Ironhand, would you like to continue shopping?
1. Yes
2. No
Choose an option: 1
Armory:
	Breastplate:
		cost: 350
		damage reduction: 600
		required level: 3
	Full_Body_Armor:
		cost: 1000
		damage reduction: 1100
		required level: 8
	Guardian_Angel:
		cost: 1000
		damage reduction: 1000
		required level: 10
	Platinum_Shield:
		cost: 150
		damage reduction: 200
		required level: 1
	Wizard_Shield:
		cost: 1200
		damage reduction: 1500
		required level: 10
FireSpells:
	Breath_of_Fire:
		cost: 350
		damage: 450
		mana cost: 100
		required level: 1
	Flame_Tornado:
		cost: 700
		damage: 850
		mana cost: 300
		required level: 4
	Heat_Wave:
		cost: 450
		damage: 600
		mana cost: 150
		required level: 2
	Hell_Storm:
		cost: 600
		damage: 950
		mana cost: 600
		required level: 3
	Lava_Comet:
		cost: 800
		damage: 1000
		mana cost: 550
		required level: 7
IceSpells:
	Arctic_Storm:
		cost: 700
		damage: 800
		mana cost: 300
		required level: 6
	Frost_Blizzard:
		cost: 750
		damage: 850
		mana cost: 350
		required level: 5
	Ice_Blade:
		cost: 250
		damage: 450
		mana cost: 100
		required level: 1
	Snow_Cannon:
		cost: 500
		damage: 650
		mana cost: 250
		required level: 2
LightningSpells:
	Electric_Arrows:
		cost: 550
		damage: 650
		mana cost: 200
		required level: 5
	Lightning_Dagger:
		cost: 400
		damage: 500
		mana cost: 150
		required level: 1
	Spark_Needles:
		cost: 500
		damage: 600
		mana cost: 200
		required level: 2
	Thunder_Blast:
		cost: 750
		damage: 950
		mana cost: 400
		required level: 4
Potions:
	Ambrosia:
		attribute affected: All_Health/Mana/Strength/Dexterity/Defense/Agility
		attribute increase: 150
		cost: 1000
		required level: 8
	Healing_Potion:
		attribute affected: Health
		attribute increase: 100
		cost: 250
		required level: 1
	Luck_Elixir:
		attribute affected: Agility
		attribute increase: 65
		cost: 500
		required level: 4
	Magic_Potion:
		attribute affected: Mana
		attribute increase: 100
		cost: 350
		required level: 2
	Mermaid_Tears:
		attribute affected: Health/Mana/Strength/Agility
		attribute increase: 100
		cost: 850
		required level: 5
	Strength_Potion:
		attribute affected: Strength
		attribute increase: 75
		cost: 200
		required level: 1
Weaponry:
	Axe:
		cost: 550
		damage: 850
		required hands: 1
		required level: 5
	Bow:
		cost: 300
		damage: 500
		required hands: 2
		required level: 2
	Dagger:
		cost: 200
		damage: 250
		required hands: 1
		required level: 1
	Scythe:
		cost: 1000
		damage: 1100
		required hands: 2
		required level: 6
	Sword:
		cost: 500
		damage: 800
		required hands: 1
		required level: 1
	TSwords:
		cost: 1400
		damage: 1600
		required hands: 2
		required level: 8

-----------------------------------------
Name: Gaerdal_Ironhand
Level: 7
HP: 700
Class: Warriors
MP: 100
Strength: 840
Agility: 600
Dexterity: 600
Money: 1004
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (1/10):
Breath_of_Fire:
	Purchase Price: 350
	Level: 1
	Type: Fire
	Mana Cost: 100
	Uses left: 3
	Damage: 450

-----------------------------------------

Gaerdal_Ironhand, would you like to buy or sell items?
1. Buy
2. Sell
3. Skip
Choose an option: 1
Select an item class to buy from: 
1. Potions
2. Weaponry
3. Armory
4. FireSpells
5. IceSpells
6. LightningSpells
Choose an option: 3
Select an item to buy: 
1. Breastplate
2. Full_Body_Armor
3. Guardian_Angel
4. Platinum_Shield
5. Wizard_Shield
Choose an option: 5
You have selected: Wizard_Shield
Buy Wizard_Shield for 1200? Gaerdal_Ironhand has 1004 gold.
1. Yes
2. No
Choose an option: 1
You are not high enough level to buy this item!
Failed to buy Wizard_Shield
-----------------------------------------
Name: Gaerdal_Ironhand
Level: 7
HP: 700
Class: Warriors
MP: 100
Strength: 840
Agility: 600
Dexterity: 600
Money: 1004
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (1/10):
Breath_of_Fire:
	Purchase Price: 350
	Level: 1
	Type: Fire
	Mana Cost: 100
	Uses left: 3
	Damage: 450

-----------------------------------------

Gaerdal_Ironhand, would you like to continue shopping?
1. Yes
2. No
Choose an option: 1
Armory:
	Breastplate:
		cost: 350
		damage reduction: 600
		required level: 3
	Full_Body_Armor:
		cost: 1000
		damage reduction: 1100
		required level: 8
	Guardian_Angel:
		cost: 1000
		damage reduction: 1000
		required level: 10
	Platinum_Shield:
		cost: 150
		damage reduction: 200
		required level: 1
	Wizard_Shield:
		cost: 1200
		damage reduction: 1500
		required level: 10
FireSpells:
	Breath_of_Fire:
		cost: 350
		damage: 450
		mana cost: 100
		required level: 1
	Flame_Tornado:
		cost: 700
		damage: 850
		mana cost: 300
		required level: 4
	Heat_Wave:
		cost: 450
		damage: 600
		mana cost: 150
		required level: 2
	Hell_Storm:
		cost: 600
		damage: 950
		mana cost: 600
		required level: 3
	Lava_Comet:
		cost: 800
		damage: 1000
		mana cost: 550
		required level: 7
IceSpells:
	Arctic_Storm:
		cost: 700
		damage: 800
		mana cost: 300
		required level: 6
	Frost_Blizzard:
		cost: 750
		damage: 850
		mana cost: 350
		required level: 5
	Ice_Blade:
		cost: 250
		damage: 450
		mana cost: 100
		required level: 1
	Snow_Cannon:
		cost: 500
		damage: 650
		mana cost: 250
		required level: 2
LightningSpells:
	Electric_Arrows:
		cost: 550
		damage: 650
		mana cost: 200
		required level: 5
	Lightning_Dagger:
		cost: 400
		damage: 500
		mana cost: 150
		required level: 1
	Spark_Needles:
		cost: 500
		damage: 600
		mana cost: 200
		required level: 2
	Thunder_Blast:
		cost: 750
		damage: 950
		mana cost: 400
		required level: 4
Potions:
	Ambrosia:
		attribute affected: All_Health/Mana/Strength/Dexterity/Defense/Agility
		attribute increase: 150
		cost: 1000
		required level: 8
	Healing_Potion:
		attribute affected: Health
		attribute increase: 100
		cost: 250
		required level: 1
	Luck_Elixir:
		attribute affected: Agility
		attribute increase: 65
		cost: 500
		required level: 4
	Magic_Potion:
		attribute affected: Mana
		attribute increase: 100
		cost: 350
		required level: 2
	Mermaid_Tears:
		attribute affected: Health/Mana/Strength/Agility
		attribute increase: 100
		cost: 850
		required level: 5
	Strength_Potion:
		attribute affected: Strength
		attribute increase: 75
		cost: 200
		required level: 1
Weaponry:
	Axe:
		cost: 550
		damage: 850
		required hands: 1
		required level: 5
	Bow:
		cost: 300
		damage: 500
		required hands: 2
		required level: 2
	Dagger:
		cost: 200
		damage: 250
		required hands: 1
		required level: 1
	Scythe:
		cost: 1000
		damage: 1100
		required hands: 2
		required level: 6
	Sword:
		cost: 500
		damage: 800
		required hands: 1
		required level: 1
	TSwords:
		cost: 1400
		damage: 1600
		required hands: 2
		required level: 8

-----------------------------------------
Name: Gaerdal_Ironhand
Level: 7
HP: 700
Class: Warriors
MP: 100
Strength: 840
Agility: 600
Dexterity: 600
Money: 1004
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (1/10):
Breath_of_Fire:
	Purchase Price: 350
	Level: 1
	Type: Fire
	Mana Cost: 100
	Uses left: 3
	Damage: 450

-----------------------------------------

Gaerdal_Ironhand, would you like to buy or sell items?
1. Buy
2. Sell
3. Skip
Choose an option: 1
Select an item class to buy from: 
1. Potions
2. Weaponry
3. Armory
4. FireSpells
5. IceSpells
6. LightningSpells
Choose an option: 3
Select an item to buy: 
1. Breastplate
2. Full_Body_Armor
3. Guardian_Angel
4. Platinum_Shield
5. Wizard_Shield
Choose an option: 1
You have selected: Breastplate
Buy Breastplate for 350? Gaerdal_Ironhand has 1004 gold.
1. Yes
2. No
Choose an option: 1
Successfully bought Breastplate
-----------------------------------------
Name: Gaerdal_Ironhand
Level: 7
HP: 700
Class: Warriors
MP: 100
Strength: 840
Agility: 600
Dexterity: 600
Money: 654
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (2/10):
Breath_of_Fire:
	Purchase Price: 350
	Level: 1
	Type: Fire
	Mana Cost: 100
	Uses left: 3
	Damage: 450
Breastplate:
	Purchase Price: 350
	Level: 3
	Defense: 600

-----------------------------------------

Gaerdal_Ironhand, would you like to continue shopping?
1. Yes
2. No
Choose an option: 2
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
D-Maleficent (Dragon) @ [0, 1]
Casper (Spirit) @ [0, 7]
Andromalius (Spirit) @ [0, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [7, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: e
Changing equipment...
What would you like to equip?
1. Weapon
2. Armor
Choose an option: 2
Breastplate:
	Purchase Price: 350
	Level: 3
	Defense: 600

1. Breastplate
Choose an option: 1

Monsters' turns!
No hero found in range!
D-Maleficent's turn: 
D-Maleficent moved forward!

No hero found in range!
Andromalius's turn: 
Andromalius moved forward!

No hero found in range!
Casper's turn: 
Casper moved forward!

Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
D-Maleficent (Dragon) @ [1, 1]
Casper (Spirit) @ [1, 7]
Andromalius (Spirit) @ [1, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [7, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: w
Amaryllis_Astra's strength increased to 500
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [6, 0]

Monsters:
D-Maleficent (Dragon) @ [1, 1]
Casper (Spirit) @ [1, 7]
Andromalius (Spirit) @ [1, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [7, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: w
Reign_Havoc's dexterity increased to 1056
Heroes:
Gaerdal_Ironhand (Warrior) @ [7, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [6, 0]

Monsters:
D-Maleficent (Dragon) @ [1, 1]
Casper (Spirit) @ [1, 7]
Andromalius (Spirit) @ [1, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [7, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: w
Gaerdal_Ironhand's dexterity increased to 660

Monsters' turns!
No hero found in range!
D-Maleficent's turn: 
D-Maleficent moved forward!

No hero found in range!
Andromalius's turn: 
Andromalius moved forward!

No hero found in range!
Casper's turn: 
Casper moved forward!

Heroes:
Gaerdal_Ironhand (Warrior) @ [6, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [6, 0]

Monsters:
D-Maleficent (Dragon) @ [2, 1]
Casper (Spirit) @ [2, 7]
Andromalius (Spirit) @ [2, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [6, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Amaryllis_Astra's agility increased to 550
Amaryllis_Astra's strength decreased to normal
Heroes:
Gaerdal_Ironhand (Warrior) @ [6, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [5, 0]

Monsters:
D-Maleficent (Dragon) @ [2, 1]
Casper (Spirit) @ [2, 7]
Andromalius (Spirit) @ [2, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [6, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Reign_Havoc's dexterity decreased to normal
Heroes:
Gaerdal_Ironhand (Warrior) @ [6, 6]
Reign_Havoc (Sorcerer) @ [5, 3]
Amaryllis_Astra (Paladin) @ [5, 0]

Monsters:
D-Maleficent (Dragon) @ [2, 1]
Casper (Spirit) @ [2, 7]
Andromalius (Spirit) @ [2, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [6, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Gaerdal_Ironhand's agility increased to 660
Gaerdal_Ironhand's dexterity decreased to normal

Monsters' turns!
No hero found in range!
D-Maleficent's turn: 
D-Maleficent moved forward!

No hero found in range!
Andromalius's turn: 
Andromalius moved forward!

No hero found in range!
Casper's turn: 
Casper moved forward!

Heroes:
Gaerdal_Ironhand (Warrior) @ [5, 6]
Reign_Havoc (Sorcerer) @ [5, 3]
Amaryllis_Astra (Paladin) @ [5, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [5, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Amaryllis_Astra's agility decreased to normal
Heroes:
Gaerdal_Ironhand (Warrior) @ [5, 6]
Reign_Havoc (Sorcerer) @ [5, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [5, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Reign_Havoc's agility increased to 1056
Heroes:
Gaerdal_Ironhand (Warrior) @ [5, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [5, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Gaerdal_Ironhand's dexterity increased to 660
Gaerdal_Ironhand's agility decreased to normal

Monsters' turns!

D-Maleficent is attacking!
D-Maleficent dealt 80 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!

Casper is attacking!
Gaerdal_Ironhand dodged the attack!
Casper dealt 0 damage to Gaerdal_Ironhand!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [4, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Amaryllis_Astra dealt 132 damage to D-Maleficent!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [4, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Andromalius dodged the attack!
Reign_Havoc dealt 0 damage to Andromalius!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Gaerdal_Ironhand dealt 84 damage to Casper!

Monsters' turns!

D-Maleficent is attacking!
Amaryllis_Astra dodged the attack!
D-Maleficent dealt 0 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!

Casper is attacking!
Gaerdal_Ironhand dodged the attack!
Casper dealt 0 damage to Gaerdal_Ironhand!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [4, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Amaryllis_Astra dealt 132 damage to D-Maleficent!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [4, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Andromalius dodged the attack!
Reign_Havoc dealt 0 damage to Andromalius!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Casper dodged the attack!
Gaerdal_Ironhand dealt 0 damage to Casper!

Monsters' turns!

D-Maleficent is attacking!
Amaryllis_Astra dodged the attack!
D-Maleficent dealt 0 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!

Casper is attacking!
Casper dealt 1 damage to Gaerdal_Ironhand!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [4, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Amaryllis_Astra dealt 132 damage to D-Maleficent!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [4, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Reign_Havoc dealt 53 damage to Andromalius!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Casper dodged the attack!
Gaerdal_Ironhand dealt 0 damage to Casper!

Monsters' turns!

D-Maleficent is attacking!
D-Maleficent dealt 80 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!

Casper is attacking!
Gaerdal_Ironhand dodged the attack!
Casper dealt 0 damage to Gaerdal_Ironhand!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [4, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Amaryllis_Astra dealt 132 damage to D-Maleficent!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [4, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Reign_Havoc dealt 53 damage to Andromalius!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
D-Maleficent (Dragon) @ [3, 1]
Casper (Spirit) @ [3, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Gaerdal_Ironhand dealt 84 damage to Casper!
Casper has been slain!
Gaerdal_Ironhand now has 1354 gold!
Gaerdal_Ironhand has gained 14 experience points! (14/70) Level 7

Monsters' turns!

D-Maleficent is attacking!
D-Maleficent dealt 80 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!
Spawning new monsters!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [4, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
D-Maleficent dodged the attack!
Amaryllis_Astra dealt 0 damage to D-Maleficent!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [4, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Andromalius dodged the attack!
Reign_Havoc dealt 0 damage to Andromalius!
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [4, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [0, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [0, 4]
Chrysophylax (Dragon) @ [0, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [4, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Gaerdal_Ironhand's dexterity decreased to normal

Monsters' turns!

D-Maleficent is attacking!
Amaryllis_Astra dodged the attack!
D-Maleficent dealt 0 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!
No hero found in range!
St-Yeenoghu's turn: 
St-Yeenoghu moved forward!

No hero found in range!
FallenAngel's turn: 
FallenAngel moved forward!

No hero found in range!
Chrysophylax's turn: 
Chrysophylax moved forward!

Heroes:
Gaerdal_Ironhand (Warrior) @ [3, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [1, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [1, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [4, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Amaryllis_Astra dealt 132 damage to D-Maleficent!
Heroes:
Gaerdal_Ironhand (Warrior) @ [3, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [1, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [1, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [4, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Reign_Havoc dealt 53 damage to Andromalius!
Heroes:
Gaerdal_Ironhand (Warrior) @ [3, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [1, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [1, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [3, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Gaerdal_Ironhand's strength increased to 600

Monsters' turns!

D-Maleficent is attacking!
Amaryllis_Astra dodged the attack!
D-Maleficent dealt 0 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!
No hero found in range!
St-Yeenoghu's turn: 
St-Yeenoghu moved forward!

No hero found in range!
FallenAngel's turn: 
FallenAngel moved forward!


Chrysophylax is attacking!
Chrysophylax dealt 1 damage to Gaerdal_Ironhand!
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [4, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [2, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [2, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [4, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: t
Teleporting...
Choose a location to teleport to:
1. [2, 7]
2. [3, 6]
3. [4, 4]
4. [5, 3]
Choose an option: 4
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [4, 3]
Amaryllis_Astra (Paladin) @ [5, 3]

Monsters:
St-Yeenoghu (Exoskeleton) @ [2, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [2, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [4, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: r
Recalling...
Reign_Havoc's agility decreased to normal
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [5, 3]

Monsters:
St-Yeenoghu (Exoskeleton) @ [2, 1]
D-Maleficent (Dragon) @ [3, 1]
FallenAngel (Spirit) @ [2, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [3, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [2, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Gaerdal_Ironhand dealt 36 damage to Chrysophylax!

Monsters' turns!
No hero found in range!
D-Maleficent's turn: 
D-Maleficent moved forward!

No hero found in range!
Andromalius's turn: 
Andromalius moved forward!

No hero found in range!
St-Yeenoghu's turn: 
St-Yeenoghu moved forward!

No hero found in range!
FallenAngel's turn: 
FallenAngel moved forward!


Chrysophylax is attacking!
Chrysophylax dealt 1 damage to Gaerdal_Ironhand!
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [5, 3]

Monsters:
St-Yeenoghu (Exoskeleton) @ [3, 1]
D-Maleficent (Dragon) @ [4, 1]
FallenAngel (Spirit) @ [3, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [4, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [5, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: t
Teleporting...
Choose a location to teleport to:
1. [2, 7]
2. [3, 6]
Choose an option: 1
Amaryllis_Astra's dexterity increased to 660
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [3, 1]
D-Maleficent (Dragon) @ [4, 1]
FallenAngel (Spirit) @ [3, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [4, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [7, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: i
1. Heroes
2. Monsters
Choose an option: 1
1. Amaryllis_Astra
2. Reign_Havoc
3. Gaerdal_Ironhand
Choose an option: 2
-----------------------------------------
Name: Reign_Havoc
Level: 8
HP: 2277
Class: Sorcerers
MP: 2277
Strength: 800
Agility: 960
Dexterity: 960
Money: 2250
-----------------------------------------
Weapon: Not Equipped
Armor: Not Equipped
-----------------------------------------
Inventory (1/10):
Healing_Potion:
	Purchase Price: 250
	Level: 1
	Effect: Health
	Change: 100

-----------------------------------------

Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [3, 1]
D-Maleficent (Dragon) @ [4, 1]
FallenAngel (Spirit) @ [3, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [4, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [7, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: p
1. Healing_Potion
Choose an option: 1
Reign_Havoc healed by 100 health!
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [3, 1]
D-Maleficent (Dragon) @ [4, 1]
FallenAngel (Spirit) @ [3, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [4, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [2, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: i
1. Heroes
2. Monsters
Choose an option: 1
1. Amaryllis_Astra
2. Reign_Havoc
3. Gaerdal_Ironhand
Choose an option: 3
-----------------------------------------
Name: Gaerdal_Ironhand
Level: 7
HP: 1021
Class: Warriors
MP: 281
Strength: 924
Agility: 600
Dexterity: 600
Money: 1354
-----------------------------------------
Weapon: Not Equipped
Armor: Breastplate:
	Purchase Price: 350
	Level: 3
	Defense: 600
-----------------------------------------
Inventory (1/10):
Breath_of_Fire:
	Purchase Price: 350
	Level: 1
	Type: Fire
	Mana Cost: 100
	Uses left: 3
	Damage: 450

-----------------------------------------

Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [3, 1]
D-Maleficent (Dragon) @ [4, 1]
FallenAngel (Spirit) @ [3, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [4, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [2, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: x
Casting spell...
1. Breath_of_Fire
Choose an option: 1
Gaerdal_Ironhand cast Breath_of_Fire on Chrysophylax!
Chrysophylax's defense went down by 1600!
Gaerdal_Ironhand dealt 56 damage to Chrysophylax!
2 uses left of Breath_of_Fire

Monsters' turns!
No hero found in range!
D-Maleficent's turn: 
D-Maleficent moved forward!

No hero found in range!
Andromalius's turn: 
Andromalius moved forward!

No hero found in range!
St-Yeenoghu's turn: 
St-Yeenoghu moved forward!

No hero found in range!
FallenAngel's turn: 
FallenAngel moved forward!


Chrysophylax is attacking!
Chrysophylax dealt 80 damage to Amaryllis_Astra!
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [4, 1]
D-Maleficent (Dragon) @ [5, 1]
FallenAngel (Spirit) @ [4, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [2, 7] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Amaryllis_Astra dealt 70 damage to Chrysophylax!
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [4, 1]
D-Maleficent (Dragon) @ [5, 1]
FallenAngel (Spirit) @ [4, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [7, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: z
No monster found in range
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [7, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [4, 1]
D-Maleficent (Dragon) @ [5, 1]
FallenAngel (Spirit) @ [4, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [7, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: w
Reign_Havoc's dexterity increased to 1056
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [4, 1]
D-Maleficent (Dragon) @ [5, 1]
FallenAngel (Spirit) @ [4, 4]
Chrysophylax (Dragon) @ [1, 7]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [2, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Gaerdal_Ironhand dealt 46 damage to Chrysophylax!
Chrysophylax has been slain!
Gaerdal_Ironhand now has 2054 gold!
Gaerdal_Ironhand has gained 28 experience points! (42/70) Level 7

Monsters' turns!
No hero found in range!
D-Maleficent's turn: 
D-Maleficent moved forward!


Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!
No hero found in range!
St-Yeenoghu's turn: 
St-Yeenoghu moved forward!

No hero found in range!
FallenAngel's turn: 
FallenAngel moved to the left!

Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [2, 7]

Monsters:
St-Yeenoghu (Exoskeleton) @ [5, 1]
D-Maleficent (Dragon) @ [6, 1]
FallenAngel (Spirit) @ [4, 3]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [2, 7] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: r
Recalling...
Amaryllis_Astra's dexterity decreased to normal
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [5, 1]
D-Maleficent (Dragon) @ [6, 1]
FallenAngel (Spirit) @ [4, 3]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [6, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
Reign_Havoc dealt 53 damage to Andromalius!
Heroes:
Gaerdal_Ironhand (Warrior) @ [2, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [5, 1]
D-Maleficent (Dragon) @ [6, 1]
FallenAngel (Spirit) @ [4, 3]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [2, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Gaerdal_Ironhand's strength increased to 600
Gaerdal_Ironhand's strength decreased to normal

Monsters' turns!

D-Maleficent is attacking!
Amaryllis_Astra dodged the attack!
D-Maleficent dealt 0 damage to Amaryllis_Astra!

Andromalius is attacking!
Reign_Havoc dodged the attack!
Andromalius dealt 0 damage to Reign_Havoc!
No hero found in range!
St-Yeenoghu's turn: 
St-Yeenoghu moved to the left!

No hero found in range!
FallenAngel's turn: 
FallenAngel moved forward!

Heroes:
Gaerdal_Ironhand (Warrior) @ [1, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [5, 0]
D-Maleficent (Dragon) @ [6, 1]
FallenAngel (Spirit) @ [5, 3]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P1) Player Amaryllis_Astra @ [7, 0] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
'M' for market
Enter choice: z
Attacking...
Amaryllis_Astra dealt 132 damage to D-Maleficent!
Heroes:
Gaerdal_Ironhand (Warrior) @ [1, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [5, 0]
D-Maleficent (Dragon) @ [6, 1]
FallenAngel (Spirit) @ [5, 3]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P2) Player Reign_Havoc @ [6, 3] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: z
Attacking...
FallenAngel dodged the attack!
Reign_Havoc dealt 0 damage to FallenAngel!
Heroes:
Gaerdal_Ironhand (Warrior) @ [1, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [5, 0]
D-Maleficent (Dragon) @ [6, 1]
FallenAngel (Spirit) @ [5, 3]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
(P3) Player Gaerdal_Ironhand @ [1, 6] --> your turn: 
Make a move: 

'WASD' for movement
'Q' to quit
'I' for info
'T' to teleport
'R' to recall
'Z' to attack
'E' to change equipment
'P' to use potion
'X' to cast spell
'F' to skip turn
Enter choice: w
Gaerdal_Ironhand's strength decreased to normal

Monsters' turns!
Heroes win!
Heroes:
Gaerdal_Ironhand (Warrior) @ [0, 6]
Reign_Havoc (Sorcerer) @ [6, 3]
Amaryllis_Astra (Paladin) @ [7, 0]

Monsters:
St-Yeenoghu (Exoskeleton) @ [5, 0]
D-Maleficent (Dragon) @ [6, 1]
FallenAngel (Spirit) @ [5, 3]
Andromalius (Spirit) @ [5, 4]

	+---+---+---+---+---+---+---+---+
 0	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
 1	| P | K | X | K | P | X | K | K |
	+---+---+---+---+---+---+---+---+
 2	| C | P | X | C | P | X | K | B |
	+---+---+---+---+---+---+---+---+
 3	| K | P | X | P | P | X | P | P |
	+---+---+---+---+---+---+---+---+
 4	| P | B | X | C | K | X | B | C |
	+---+---+---+---+---+---+---+---+
 5	| C | K | X | P | B | X | C | P |
	+---+---+---+---+---+---+---+---+
 6	| K | P | X | B | P | X | B | C |
	+---+---+---+---+---+---+---+---+
 7	| N | N | X | N | N | X | N | N |
	+---+---+---+---+---+---+---+---+
	  0   1   2   3   4   5   6   7 
Do you want to play another game? (1 for Y, 2 for N)
1. Y
2. N
Choose an option: Y
Invalid entry.
1. Y
2. N
Choose an option: 1

88888888888888888888888888888888888888888888888888888888888888888888888
88.._|      | `-.  | `.  -_-_ _-_  _-  _- -_ -  .'|   |.'|     |  _..88
88   `-.._  |    |`!  |`.  -_ -__ -_ _- _-_-  .'  |.;'   |   _.!-'|  88
88      | `-!._  |  `;!  ;. _______________ ,'| .-' |   _!.i'     |  88
88..__  |     |`-!._ | `.| |_______________||."'|  _!.;'   |     _|..88
88   |``"..__ |    |`";.| i|_|MMMMMMMMMMM|_|'| _!-|   |   _|..-|'    88
88   |      |``--..|_ | `;!|l|MMoMMMMoMMM|1|.'j   |_..!-'|     |     88
88   |      |    |   |`-,!_|_|MMMMP'YMMMM|_||.!-;'  |    |     |     88
88___|______|____!.,.!,.!,!|d|MMMo * loMM|p|,!,.!.,.!..__|_____|_____88
88      |     |    |  |  | |_|MMMMb,dMMMM|_|| |   |   |    |      |  88
88      |     |    |..!-;'i|r|MPYMoMMMMoM|r| |`-..|   |    |      |  88
88      |    _!.-j'  | _!,"|_|M<>MMMMoMMM|_||!._|  `i-!.._ |      |  88
88     _!.-'|    | _."|  !;|1|MbdMMoMMMMM|l|`.| `-._|    |``-.._  |  88
88..-i'     |  _.''|  !-| !|_|MMMoMMMMoMM|_|.|`-. | ``._ |     |``"..88
88   |      |.|    |.|  !| |u|MoMMMMoMMMM|n||`. |`!   | `".    |     88
88   |  _.-'  |  .'  |.' |/|_|MMMMoMMMMoM|_|! |`!  `,.|    |-._|     88
88  _!"'|     !.'|  .'| .'|[@]MMMMMMMMMMM[@] \|  `. | `._  |   `-._  88
88-'    |   .'   |.|  |/| /                 \|`.  |`!    |.|      |`-88
88      |_.'|   .' | .' |/                   \  \ |  `.  | `._-Lee|  88
88     .'   | .'   |/|  /                     \ |`!   |`.|    `.  |  88
88  _.'     !'|   .' | /                       \|  `  |  `.    |`.|  88
88 WELCOME TO THE PARTY 8888888888888888888888888888888888888888(FL)888

Which game would you like to play? 

1. Legends of Monsters and Heroes
2. Legends Of Valor

Process finished with exit code 0
```