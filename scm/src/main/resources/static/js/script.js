console.log("Script loded");

let currTheme = getTheme();
//initially
changeTheme();

function changeTheme(theme) {
  //set to web page
  document.querySelector("html").classList.add(currTheme);

  //set listner
  const chgThemebtn = document.querySelector("#theme-chg-btn");
  chgThemebtn.querySelector("span").textContent =
    currTheme === "light" ? "dark" : "light";
  chgThemebtn.addEventListener("click", (event) => {
    const oldTheme = currTheme;
    console.log("change theme btn clickedd");
    // document.querySelector("html").classList.remove(currTheme);

    if (currTheme === "dark") {
      currTheme = "light";
    } else {
      currTheme = "dark";
    }
    //update to local storage
    setTheme(currTheme);
    document.querySelector("html").classList.remove(oldTheme);
    document.querySelector("html").classList.add(currTheme);

    //change the txt
    chgThemebtn.querySelector("span").textContent =
      currTheme === "light" ? "dark" : "light";
  });
}
//set theme to local storage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

// get theme from local storage

function getTheme() {
  let theme = localStorage.getItem("theme");

  return theme ? theme : "light";
}

function changePageTheme(){
    
}
