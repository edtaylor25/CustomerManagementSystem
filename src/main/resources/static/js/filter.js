function searchCard() {
   let input = document.getElementById('filter').value.toUpperCase(); //uppercase to equate all values for search 
   input = input.trim(); //trimmed white spaces 
   

   const cardContainer = document.getElementById('card-lists'); //narrows search 
  

   const cards = cardContainer.getElementsByClassName('card-filter'); //narrows search within card div further
  

   for(let i = 0; i<cards.length; i++) {
    let search = cards[i].querySelector(".card-body"); //search individual card 
   

    if(search.innerText.toUpperCase().indexOf(input) > -1) { //taking text within card body and uppercasing 
        cards[i].style.display = ""; //if the search input is within the text, then dont change the display. 
    }
    else {
        cards[i].style.display = "none"; //else hide the display 
    }
   }
}
