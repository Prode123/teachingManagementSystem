function move(e) {
    const x = e.pageX - e.target.offsetLeft;
    const y = e.pageY - e.target.offsetTop;
    e.target.style.setProperty('--x', `${x}px`);
    e.target.style.setProperty('--y', `${y}px`);
}

function onSubmit(e) {
    e.preventDefault(); // 阻止表单提交
    const form = e.target;
    console.log(params);
}

function onPwdInput(e) {
    confirmPwd.pattern = e.target.value;
}
let selects = document.querySelector('#select');
let date = document.querySelector('#date');

let dataParent = document.querySelector('#date-parent');

var year = new Date().getFullYear();
var month =
    new Date().getMonth() + 1 < 10 ? '0' + (new Date().getMonth() + 1) : new Date().getMonth() + 1;
var day = new Date().getDate() < 10 ? '0' + new Date().getDate() : new Date().getDate();

date && (date.value = `${year}-${month}-${day}`);

date &&
    (date.onchange = function() {
        // if (date.value) {
        //   dataParent.removeChild(dataParent.lastElementChild);
        // }
        (this.style.border = '1px solid #056ffa'), (this.style.borderLeftWidth = '5px ');
    });

// select.onchange = function () {
//   this.className = 'active';
// };