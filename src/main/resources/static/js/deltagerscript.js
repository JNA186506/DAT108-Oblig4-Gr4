const root = document.getElementById("root");
const fornavnInput = root.querySelector("#fornavn");
const etternavnInput = root.querySelector("#etternavn");
const nummerInput = root.querySelector("#nummer");
const passord1Input = root.querySelector("#passord1");
const passord2Input = root.querySelector("#passord2");
const submitBtn = root.querySelector("#submitBtn");

function validateNavn(input, fieldName) {
    const nameRegex = /^[a-zæøåA-ZÆØÅ]+([ -][a-zæøåA-ZÆØÅ]+)*$/;
    const value = input.value.trim();

    input.setCustomValidity("");

    if (!value) {
        input.setCustomValidity(`${fieldName} er påkrevd`);
        input.reportValidity();
        return false;
    }

    if (value.length < 2 || !nameRegex.test(value)) {
        input.setCustomValidity("Navnet må inneholde minst to bokstaver. Kun bokstaver, mellomrom og bindestrek er tillatt");
        input.reportValidity();
        return false;
    }

    return true;
}

function validatePhone(input) {
    const digitsOnly = /\d/g;
    const value = input.value.trim();

    input.setCustomValidity("");

    if (!value) {
        input.setCustomValidity("Mobilnummer er påkrevd");
        input.reportValidity();
        return false;
    }

    const digits = (value.match(digitsOnly) || []).length;

    if (digits !== 8) {
        input.setCustomValidity("Mobilnummer må inneholde nøyaktig 8 siffer");
        input.reportValidity();
        return false;
    }

    return true;
}

function validateInput() {
    return validateNavn(fornavnInput, "Fornavn") &&
        validateNavn(etternavnInput, "Etternavn") &&
        validatePhone(nummerInput);
}

submitBtn.addEventListener("click", (e) => {
    if (!validateInput()) {
        e.preventDefault();
    }
})
