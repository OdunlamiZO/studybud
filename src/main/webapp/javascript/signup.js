$(document).ready(function() {
    const form = document.getElementsByTagName("form")[0];
    const inputs = document.getElementsByTagName("input");
    const firstName = inputs[0];
    const lastName = inputs[1];
    const email = inputs[2];
    const password = inputs[3];
    form.addEventListener("submit", (e) => {
	    e.preventDefault();
        let isFirstNameValid = validateFirstName(),
            isLastNameValid = validateLastName(),
            isEmailValid = validateEmail(),
            isPasswordValid = validatePassword();
        let isFormValid = isFirstNameValid &&
                            isLastNameValid &&
                            isEmailValid &&
                            isPasswordValid;
        if(isFormValid) {
            form.submit();
        }
    });
    firstName.addEventListener("focus", function() {
        const hasFailed = firstName.classList.contains("failed");
        if(hasFailed) {
            const alert = $("#first_name .error");
            if($(window).width() <= 640) {
                alert.addClass("hidden");
            }else {
                alert.removeClass("hidden");
            }
        }
    });
    firstName.addEventListener("blur", function() {
        const alert = $("#first_name .error");
        const hasFailed = firstName.classList.contains("failed");
        if(hasFailed && !isEmpty(firstName.value.trim())) {
            if($(window).width() > 640) {
                alert.addClass("hidden");
            }
            firstName.classList.remove("failed");
        }
        if(hasFailed && isEmpty(firstName.value.trim())) {
            if($(window).width() <= 640) {
                alert.removeClass("hidden");
            }
        }
    });
    lastName.addEventListener("focus", function() {
        const hasFailed = lastName.classList.contains("failed");
        if(hasFailed) {
            const alert = $("#last_name .error");
            if($(window).width() <= 640) {
                alert.addClass("hidden");
            }else {
                alert.removeClass("hidden");
            }
        }
    });
    lastName.addEventListener("blur", function() {
        const alert = $("#last_name .error");
        const hasFailed = lastName.classList.contains("failed");
        if(hasFailed && !isEmpty(lastName.value.trim())) {
            if($(window).width() > 640) {
                alert.addClass("hidden");
            }
            lastName.classList.remove("failed");
        }
        if(hasFailed && isEmpty(lastName.value.trim())) {
            if($(window).width() <= 640) {
                alert.removeClass("hidden");
            }
        }
    });
    email.addEventListener("focus", function() {
        const hasFailed = email.classList.contains("failed");
        if(hasFailed) {
            $("#email .error").addClass("hidden");
        }
    });
    email.addEventListener("blur", function() {
        const hasFailed = email.classList.contains("failed");
        if(hasFailed && validateEmail()) {
            email.classList.remove("failed");
        }
    });
    password.addEventListener("focus", function() {
        const hasFailed = password.classList.contains("failed");
        if(hasFailed) {
            $("#password .error").addClass("hidden");
        }
    });
    password.addEventListener("blur", function() {
        const hasFailed = password.classList.contains("failed");
        if(hasFailed && validatePassword()) {
            password.classList.remove("failed");
        }
    });
    const isEmpty = (value) => value.length === 0 ? true : false;
    const match = (regex, value) => regex.test(value);
    const validateFirstName = () => {
        let isValid = true;
        if(isEmpty(firstName.value.trim())) {
            firstName.classList.add("failed");
            if($(window).width() <= 640) {
                $("#first_name .error").removeClass("hidden");
            }
            isValid = false;
        }
        return isValid;
    };
    const validateLastName = () => {
        let isValid = true;
        if(isEmpty(lastName.value.trim())) {
            lastName.classList.add("failed");
            if($(window).width() <= 640) {
                $("#last_name .error").removeClass("hidden");
            }
            isValid = false;
        }
        return isValid;
    };
    const validateEmail = () => {
        const alert = $("#email .error");
        let isValid = true;
        if(isEmpty(email.value.trim())) {
            email.classList.add("failed");
            alert.removeClass("hidden");
            isValid = false;
        }
        if(!match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/, email.value.trim())) {
            email.classList.add("failed");
            alert.removeClass("hidden");
            isValid = false;
        }
        return isValid;
    };
    const validatePassword = () => {
        const alert = $("#password .error");
        let isValid = true;
        if(isEmpty(password.value.trim())) {
            password.classList.add("failed");
            alert.removeClass("hidden");
            isValid = false;
        }
        if(!match(/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/, password.value.trim())) {
            password.classList.add("failed");
            alert.removeClass("hidden");
            isValid = false;
        }
        return isValid;
    };
});