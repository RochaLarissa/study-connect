const container = document.querySelector(".container"),
      pwShowHide = document.querySelectorAll(".showHidePw"),
      pwFields = document.querySelectorAll(".password"),
      signUp = document.querySelector(".signup-link"),
      login = document.querySelector(".login-link");

    //   js code to show/hide password and change icon
    pwShowHide.forEach(eyeIcon =>{
        eyeIcon.addEventListener("click", ()=>{
            pwFields.forEach(pwField =>{
                if(pwField.type ==="password"){
                    pwField.type = "text";

                    pwShowHide.forEach(icon =>{
                        icon.classList.replace("uil-eye-slash", "uil-eye");
                    })
                }else{
                    pwField.type = "password";

                    pwShowHide.forEach(icon =>{
                        icon.classList.replace("uil-eye", "uil-eye-slash");
                    })
                }
            }) 
        })
    })

    // js code to appear signup and login form
    signUp.addEventListener("click", ( )=>{
        container.classList.add("active");
    });
    login.addEventListener("click", ( )=>{
        container.classList.remove("active");
    });




    function performLogin() {
        // Obtenha os valores dos campos de entrada
        var email = document.getElementById('emailInput').value;
        var password = document.getElementById('passwordInput').value;
    
        // Crie um objeto para os dados do login
        var loginData = {
            email: email,
            password: password
        };
    
        // Realize uma solicitação AJAX para o endpoint de login no backend
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'URL_DO_SEU_ENDPOINT_DE_LOGIN', true);
        xhr.setRequestHeader('Content-Type', 'application/json');
    
        xhr.onload = function () {
            if (xhr.status === 200) {
                // Login bem-sucedido, faça algo aqui, como redirecionar para outra página
                window.location.href = 'home.html';
            } else {
                alert('Erro ao fazer login. Verifique suas credenciais.');
            }
        };
    
        // Converta o objeto de dados para uma string JSON e envie
        xhr.send(JSON.stringify(loginData));
    }