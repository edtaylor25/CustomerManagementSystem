function searchCard() {
   let input = document.getElementById('filter').value.toUpperCase();
   input = input.trim();
   console.log(input);

   const cardContainer = document.getElementById('card-lists');
   console.log(cardContainer);

   const cards = cardContainer.getElementsByClassName('card-filter');
   console.log(cards);

   for(let i = 0; i<cards.length; i++) {
    let search = cards[i].querySelector(".card-body");
    console.log(search);

    if(search.innerText.toUpperCase().indexOf(input) > -1) {
        cards[i].style.display = "";
    }
    else {
        cards[i].style.display = "none";
    }
   }
}
