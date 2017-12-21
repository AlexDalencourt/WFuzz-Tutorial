var loginForm = document.querySelector("#loginForm");
var loginFormRaw = document.querySelector("#loginFormRaw");
var errorLogin = document.querySelector("#errorLogin");

var userName;

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
				userName = $("#login").val();
				listFiles();
			}
		}
	).fail(function(xhr, status, error){errorLogin.classList.remove("hidden")});
}

function listFiles(){
	//<a href="#" class="list-group-item list-group-item-action">item</a>
}

loginForm.addEventListener("submit", connect, true);
