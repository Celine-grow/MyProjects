import json
import difflib
dictionary_content=json.load(open("data.json"))


def dictionary(lower_dict):
    return dictionary_content[lower_dict]
print("Search Word Definition\n")

dictWord=input("Enter your word").strip()

lower_dict=dictWord.lower()

if lower_dict in dictionary_content:
    definition=dictionary(lower_dict)
    print(f"The word  {dictWord} means:{definition}")
elif (difflib.get_close_matches(lower_dict, dictionary_content.keys(), cutoff=0.8)):
    closest_matches=difflib.get_close_matches(lower_dict,dictionary_content.keys())
    if closest_matches:
        print(f"Did you mean one of these words?")
        print(closest_matches)
        approve = input("Enter 'yes' if you meant one of these words, otherwise 'no': ").strip()
        if approve.lower()=='yes':
            myclosestMatch=input("Which word from above options you meant").strip()
            print(f"Using closest match: {myclosestMatch}")
            definition=dictionary(myclosestMatch)
            print(f"The definition of '{myclosestMatch}' is: {definition}")
        else:
                
            print(f"The word  {lower_dict} does not exist in dictionary\n") 
            
else:
     print(f"The word {dictWord} does not exist in dictionary") 
