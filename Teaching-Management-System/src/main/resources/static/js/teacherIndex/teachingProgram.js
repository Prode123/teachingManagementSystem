(function () {
  //做选项卡：把原有样式去掉，再加上新的样式
  //先给俩标签获取到，做它们俩来回切换的JavaScript
  var aSpan = document.querySelectorAll('.tab-manage');
  //再获取到俩装着表格的div
  var aDiv = document.querySelectorAll('.wrapper-div-table');
  //整一个一眼就能看出来当前标签页是哪个的效果
  for (var i = 0; i < aSpan.length; i++) {
    //鼠标点击的时候加上背景色
    aSpan[i].index = i; //使用变量index存储当前的下标
    aSpan[i].onclick = function () {
      //首先去掉所有样式
      for (var i = 0; i < aSpan.length; i++) {
        //让标签页去掉颜色
        aSpan[i].classList.remove('bgc');
        //让内容去掉可视的样式
        //因为循环运算只是一瞬间的事情所以this.index找不到特定对象于是直接使用i即可
        aDiv[i].classList.remove('show');
      }
      //在添加上需要的样式
      //给对应的标签页加上背景色
      this.classList.add('bgc');
      //给对应的盒子加上show，使他们出现
      aDiv[this.index].classList.add('show');
    };
  }
//下拉框样式
let select = document.querySelectorAll('.select');
for(var i=0; i<select.length;i++) {
  select[i].index = i;
  select[i].onchange =function() {
    this.classList.add('active');
  }
}
//查询学院列表
// const faculty = document.querySelectorAll('.faculty');
// request.get('/manangmentSystem/user/getCollegeList').then((res) => {
//   const options = res.data.data;
//   for (let i = 0; i < faculty.length; i++) {
//     for (let item of options) {
//       const coption = document.createElement('option');
//       coption.innerText = item.faculty;
//       coption.value = item.faculty;
//       faculty[i].appendChild(coption);
//     }
//   }
// });

})();
