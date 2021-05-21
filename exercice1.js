livre1 = {
    reference: "1",
    titre : "L'appel de Cthulhu",
    auteur :"H. P. Lovecraft"
};

livre2 = {
    reference : "2",
    titre :"Ring",
    auteur : "Kōji Suzuki"
};

livre3 = {
    reference : "3",
    titre: "Carrie",
    auteur : "Stephen King"
};

livres = [livre1, livre2, livre3];

function mkHtml (livres) {
    result = '';
    for (let unLivre of livres){
        result += `"${unLivre.titre}", par "${unLivre.auteur}"\n`;
    }
    return result;
}

/*
9 h 34
8. Implémentez un listener sur le formulaire, qui, lorsque que ce dernier est "soumis", ajoute un nouveau livre (objet) dans le tableau livres. Pour cela, utilisez la méthode JS push() (à chercher dans la doc)
*/


// ajouter nouveau livre à mon tableau
var formNewbook = document.getElementById("addLivre");
formNewbook.addEventListener("submit", function(event){
    event.preventDefault ;
    // afficher resultat

    let newReference = livres.length + 1 ;
    newReference = newReference.toString();

    let newBook = {
        reference : newReference,
        titre: titre.value,
        auteur : auteur.value
    };

    livres.push(newBook);
    console.log(livres);
})