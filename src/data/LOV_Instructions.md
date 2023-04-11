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

Hero's attack damage (with a weapon, hero cannot attack without a weapon) = `(strength + weapon damage) * 0.1`

Legend dodge chance = `(1 - Math.pow(dodgeFactor, legend dodgeAmt))` (dodgeFactor is 0.99 for heroes, 0.999 for monsters)

Exp needed to level up: `10 * current level`

Players and monsters never regain health/mp during a battle.

Hero gold gain = `100 * max level of monsters defeated`

Hero exp gain = `size of monster party + level of monsters defeated * 10`

Hero hp/mp gain = `baseHP or baseMP stat * 1.1`

## 8. GLHF!