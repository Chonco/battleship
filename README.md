# Battleship

Is a simple battleship command line game.

As the original game, both players starts placing their ships (one at the time) to after shoot the others ships (again, one at the time).

## Installation

Doesn't require extra installations

## Compile and run

```
javac Battleship.java
java Battleship
```

## Usage

You'll see the board like this
```
  1 2 3 4 5 6 7 8 9 10 
A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```

### Codes

- ~ = fog
- O = ship cell
- X = ship cell shoted
- M = shot missed

To input an coordenate <*y-axis*><*x-axis*> (no spaces)

To put a ship you have to input two coordinates separated by space(s). Doesn't matter the order.

### Example:

A1 A5 (put an Aircraft Carrier)
```
  1 2 3 4 5 6 7 8 9 10 
A O O O O O ~ ~ ~ ~ ~  
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```

A2 (shot to ship)
```
  1 2 3 4 5 6 7 8 9 10 
A ~ X ~ ~ ~ ~ ~ ~ ~ ~  
B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  
C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~  
D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
[MIT](https://choosealicense.com/licenses/mit/)