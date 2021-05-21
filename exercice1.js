livre1 = {
    reference: "00000000",
    titre : "L'appel de Cthulhu",
    auteur :"H. P. Lovecraft"
};

livre2 = {
    reference : "00000001",
    titre :"Ring",
    auteur : "Kōji Suzuki"
};

livre3 = {
    reference : "00000002",
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
