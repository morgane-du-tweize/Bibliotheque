let livre1 = {
    reference: "1",
    titre : "L'appel de Cthulhu",
    auteur :"H. P. Lovecraft"
};

let livre2 = {
    reference : "2",
    titre :"Ring",
    auteur : "Kōji Suzuki"
};

let livre3 = {
    reference : "3",
    titre: "Carrie",
    auteur : "Stephen King"
};

let livres = [livre1, livre2, livre3];


function mkHtml (livres) {
    result = '';
    for (let unLivre of livres){
        result += `"${unLivre.titre}", par "${unLivre.auteur}"\n`;
    }
    return result;
}

document.getElementById("listOfBooks").textContent = (mkHtml(livres));

var formNewbook = document.getElementById("addLivre");

formNewbook.addEventListener("submit", function (event){
    event.preventDefault() ;

    let newReference = livres.length + 1 ;
    newReference = newReference.toString();

    let newBook = {
        reference : newReference,
        titre: titre.value,
        auteur : auteur.value
    };

    livres.push(newBook);
    document.getElementById("listOfBooks").textContent = (mkHtml(livres));

});
