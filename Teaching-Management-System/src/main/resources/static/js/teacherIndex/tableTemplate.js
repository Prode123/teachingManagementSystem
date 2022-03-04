window.addEventListener('load',function(){
  //人才培养方案模板
  let teaPersonnelJson = [{
    number:"1",
    institute:'计算机与信息技术学院',
    major:'计算机科学与技术',
    grade:'2020级',
    level:"0",
    status:'审核通过',
    operation:1
  }];
  let teaPersonnel = document.querySelector('.tea-personnel-tbody');
  let html = template('teaPersonneldoc',{
    items:teaPersonnelJson,
  });
  teaPersonnel.innerHTML = html;
});