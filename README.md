# PyJaC-IEEE

### Introduction
This program converts between Decimal and IEEE-754.

It uses a simple but effective GUI which allows users to manipulate each individual bit in a 32-bit IEEE-754 representation.

### Functionality
Using input from a decimal number, a 32 character string representing the IEEE-754 number, or from 32 checkboxes representing individual bits that can be switched on or off, the program allows for both-way Decimal and IEEE conversion. 

The program also falls back to console mode if the GUI closes (provided it is being run on an IDE).

### Converting from IEEE to Decimal
<img src="IEEE-to-Decimal.gif" width=1070 height=260>
    
### Inputting a Decimal directly to convert to IEEE
<img src="Decimal-to-IEEE.gif" width=1070 height=260>

### Requirements

The program may compile using older versions, but was built using the following:

* Java 11 Hotspot: https://adoptopenjdk.net/

* Java FX 20.0.2: https://gluonhq.com/products/javafx/

