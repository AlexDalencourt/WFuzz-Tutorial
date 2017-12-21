var loginForm = document.querySelector("#loginForm");
var loginFormRaw = document.querySelector("#loginFormRaw");
var errorLogin = document.querySelector("#errorLogin");

function connect(event) {
	event.preventDefault();
	
	$.post(
		"http://localhost:8080/login",
		{
			login : $("#login").val(),
			pwd : $("#pwd").val()
		},
		function(data, status){
			if(status == "success"){
				loginFormRaw.classList.add("hidden");
				errorLogin.classList.add("hidden");
			}
		}
	).fail(function(xhr, status, error){errorLogin.classList.remove("hidden")});
}

loginForm.addEventListener("submit", connect, true);
