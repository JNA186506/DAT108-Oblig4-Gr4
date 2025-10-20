const root = document.getElementById("root");
const fornavnInput = root.querySelector("#fornavn");
const etternavnInput = root.querySelector("#etternavn");
const nummerInput = root.querySelector("#nummer");
const passord1Input = root.querySelector("#passord1");
const passord2Input = root.querySelector("#passord2");
const submitBtn = root.querySelector("#submitBtn");

function validateInput() {
    const regExpNavn = /^([a-zæøå]{2,}(\s+|-*))/gi;

    const validFornavn = regExpNavn.test(fornavnInput.value.trim());
    const validEtternavn = regExpNavn.test(etternavnInput.value.trim());

    const validNummer = nummerInput.validity();
}

submitBtn.addEventListener("click", () => validateInput())