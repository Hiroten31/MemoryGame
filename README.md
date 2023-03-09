# Java Learning
Recalling and learning new stuff about Java. The most simple programs to train structural programming. And yes, I see all of those mistakes I made :sweat_smile:
Note: Repository is called 'Java Learning', because there was more Java programms, but they weren't anything worth saving 

# Memory Game
## How to run the program?  
  
Import it to your IDE and choose SDK. Then just run the .java file! :grin:  
  
## Program that will play a memory game with you using words.

### 1. You can determine how much rows and collumns will be there:  
The range is between 2 pairs of words to 50 pairs (because there is 50 words in file), so maximum size is 10x10. Also if you try to make a matrix with uneven amount of pairs like 3x3, which will need 4.5 pairs, it will make one, first 'X' as 'EMPTY' word disable from game (example of 3x3 <link>) 
![image](https://user-images.githubusercontent.com/97809912/224005468-ea5d372e-ce7a-4dc7-802e-f1a47fa2c44c.png)

### 2. Then program will randomly pick right amount of words from 'words.txt' file.  
![image](https://user-images.githubusercontent.com/97809912/224005217-a969a7eb-e121-4afa-baff-ca067730722c.png)

### 3. The program also will scale itself to look slick and compactly :star_struck:  
'guitar' is the longest word which dictate to leave 6 character free for a word and 3 extra to make clear columns:
![image](https://user-images.githubusercontent.com/97809912/224001070-6f68c5fc-c402-4910-8a0e-67d6e3abc6a5.png)  
'shipwreck' is the longest word which dictate to leave 9 character free for a word and 3 extra to make clear columns:
![image](https://user-images.githubusercontent.com/97809912/224000898-eb6b19d9-e2e4-4431-acc0-590569ce9a8e.png)  

### 4. To play you will need to give the row and colums of 'X' you want to uncover.  
![image](https://user-images.githubusercontent.com/97809912/224006286-5c36c2ef-30a0-4450-a824-4e116f6cea8c.png)
![image](https://user-images.githubusercontent.com/97809912/224006631-0b1677af-cb53-4ee9-9d62-e977d7b15570.png)

The program won't allow you to enter the same coordinates or coordinates of already uncovered word! :no_entry:  
  
The score at the end is determine by amount of hearths you have left and amount of words to guess :heart::heart::heart:  

## What I've learned from it?
