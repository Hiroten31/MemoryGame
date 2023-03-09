# Memory Game  
Recalling and learning new stuff about Java. The most simple program to train structural programming. And yes, I see all of those mistakes I made :sweat_smile:  

## How to run the program? :runner:  
  
Import it to your IDE and choose SDK. Then just run the .java file! :grin:  
  
## Program that will play a memory game with you using words :joystick:

### 1. You can determine how much rows and collumns will be there:  
The range is between 2 to 50 pairs of words (because there is 50 words in file), so maximum size is 10x10 and minumum is 2x2.  
![image](https://user-images.githubusercontent.com/97809912/224005468-ea5d372e-ce7a-4dc7-802e-f1a47fa2c44c.png)  
Also if you try to make a matrix with uneven amount of pairs like 3x3, which will need 4.5 pairs, it will make the first 'X' as 'EMPTY' word, disabled from game ([example of 3x3](#4-the-program-also-will-scale-itself-to-look-slick-and-compactly-star_struck)).

### 2. Then program will randomly pick right amount of random words from 'words.txt' file.  
![image](https://user-images.githubusercontent.com/97809912/224005217-a969a7eb-e121-4afa-baff-ca067730722c.png)

### 3. To play you will need to give the row and column of 'X' you want to uncover.  
![image](https://user-images.githubusercontent.com/97809912/224006286-5c36c2ef-30a0-4450-a824-4e116f6cea8c.png)
![image](https://user-images.githubusercontent.com/97809912/224006631-0b1677af-cb53-4ee9-9d62-e977d7b15570.png)

And as you can see, we uncovered two different words. It means that we lose 1 heart and words will stay uncover until you give next coordinates. Then those two chosen before words will transform back to 'X' and only new word will be uncovered in matrix.  
  
If you would uncovered two words and they would be the same, you won't lose heart and also the words stays uncovered for the rest of the game, as well as they are disabled from chosing in the future.

### 4. The program also will scale itself to look slick and compactly :star_struck:  
'guitar' is the longest word which dictate to leave 6 character free for a word and 3 extra to make clear columns:
![image](https://user-images.githubusercontent.com/97809912/224001070-6f68c5fc-c402-4910-8a0e-67d6e3abc6a5.png)  
'shipwreck' is the longest word which dictate to leave 9 character free for a word and 3 extra to make clear columns:
![image](https://user-images.githubusercontent.com/97809912/224000898-eb6b19d9-e2e4-4431-acc0-590569ce9a8e.png)  

The program won't allow you to enter the same coordinates or coordinates of already uncovered word! :no_entry:  
  
The score at the end is determine by amount of hearths you have left and amount of words you have to guess :heart::heart::heart:  

## What I've learned from it? :book:  
I can confidently say that it was a nice way to recall the Java language, the methods that it uses, whole structure and norms of this language.  
I've trained usage of:
- collections, 
- printf function, 
- basic for loops, 
- method building, 
- do while, 
- reading file and user input 
- and of course logic.
