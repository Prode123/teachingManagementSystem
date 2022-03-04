(function () {
    //做选项卡：把原有样式去掉，再加上新的样式
  //先给俩标签获取到，做它们俩来回切换的JavaScript
  var aSpan = document.querySelectorAll('.tab-manage-award');
  //再获取到俩装着表格的div
  var aDiv = document.querySelectorAll('.wrapper-award-table');
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
// 查询个人奖项
request
.get(
  '/manangmentSystem/fileOperate/getAllFiles?pageNum=%3CpageNum%3E&pageSize=%3CpageSize%3E&uid=%3Cuid%3E&condition=%3Ccondition%3E&fileType=%3CfileType%3E&major=%3Cmajor%3E&semester=%3Csemester%3E&fileName=%3CfileName%3E&category=%3Ccategory%3E&status=%3Cstatus%3E'
)
.then((res) => {
  console.log('查询个人奖项', res);
  let individualAward = document.querySelectorAll('.award-tbody');
  // let list = res.data.list;
  // let teaClass = template('teaClassDoc', list);
  // for (let i = 0; i < teaClassDoc.length; i++) {
  //   teaClassDoc[i].innerHTML = teaClass;
  // }
  // teaClassDoc[0].innerHTML = teaClass;
  let result = {
    "code": 200,
    "msg": "OK",
    "data": {
      "total": 1,
      "list": [{
          "pizId": null,
          "ptime": null,
          "pwinner": "罗翔",
          "psponsor": null,
          "plevel": "A类",
          "category": 0,
          "title": "小红花灭霸",
          "number": "HA20220222",
          "pname": "传智杯编程竞赛",
          "tid": null,
          "tname": "小张",
          "pathFront": null,
          "createTime": null,
          "modifiedTime": null,
          "uid": 1,
          "faculty": null,
          "grade": null,
          "status": 1,
          "reason": null,
          "auditId": null,
          "isDelete": null
        },{
          "pizId": null,
          "ptime": null,
          "pwinner": "张三",
          "psponsor": null,
          "plevel": "A类",
          "category": 0,
          "title": "小红花",
          "number": "HA20220223",
          "pname": "传智杯编程竞赛",
          "tid": null,
          "tname": "小张",
          "pathFront": null,
          "createTime": null,
          "modifiedTime": null,
          "uid": 1,
          "faculty": null,
          "grade": null,
          "status": 1,
          "reason": null,
          "auditId": null,
          "isDelete": null
        }],
      "pageNum": 1,
      "pageSize": 5,
      "size": 1,
      "startRow": 1,
      "endRow": 1,
      "pages": 1,
      "prePage": 0,
      "nextPage": 0,
      "isFirstPage": true,
      "isLastPage": true,
      "hasPreviousPage": false,
      "hasNextPage": false,
      "navigatePages": 8,
      "navigatepageNums": [1],
      "navigateFirstPage": 1,
      "navigateLastPage": 1
    }
  
    }
    let list = result.data.list;
    let myawards = template('individualAward',list);
    for (let i = 0; i < individualAward.length; i++) {
      individualAward[i].innerHTML = myawards;
    }
});

//学院奖项
request
.get(
  '/manangmentSystem/fileOperate/getAllFiles?pageNum=%3CpageNum%3E&pageSize=%3CpageSize%3E&uid=%3Cuid%3E&condition=%3Ccondition%3E&fileType=%3CfileType%3E&major=%3Cmajor%3E&semester=%3Csemester%3E&fileName=%3CfileName%3E&category=%3Ccategory%3E&status=%3Cstatus%3E'
)
.then((res) => {
  console.log('查询学院奖项', res);
  let academyAward = document.querySelectorAll('.team-award-tbody');
  // let list = res.data.list;
  // let teaClass = template('teaClassDoc', list);
  // for (let i = 0; i < teaClassDoc.length; i++) {
  //   teaClassDoc[i].innerHTML = teaClass;
  // }
  // teaClassDoc[0].innerHTML = teaClass;
  let result = {
    "code": 200,
    "msg": "OK",
    "data": {
      "total": 1,
      "list": [
        {
          "pizId": null,
          "ptime": "2020/02/02",
          "pwinner": "罗翔",
          "psponsor": "传智工作室",
          "plevel": "A类",
          "category": 0,
          "title": "小红花灭霸",
          "number": "HA20220222",
          "pname": "传智杯编程竞赛",
          "tid": null,
          "tname": "小张",
          "pathFront": null,
          "createTime": null,
          "modifiedTime": null,
          "uid": 1,
          "faculty": "计算机与信息技术学院",
          "grade": null,
          "status": 1,
          "reason": null,
          "auditId": null,
          "isDelete": null
        },{
          "pizId": null,
          "ptime": "2020/02/02",
          "pwinner": "罗翔",
          "psponsor": "传智工作室",
          "plevel": "A类",
          "category": 0,
          "title": "小红花灭霸",
          "number": "HA20220223",
          "pname": "传智杯编程竞赛",
          "tid": null,
          "tname": "小张",
          "pathFront": null,
          "createTime": null,
          "modifiedTime": null,
          "uid": 1,
          "faculty": "计算机与信息技术学院",
          "grade": null,
          "status": 1,
          "reason": null,
          "auditId": null,
          "isDelete": null
        },
      ],
      "pageNum": 1,
      "pageSize": 5,
      "size": 1,
      "startRow": 1,
      "endRow": 1,
      "pages": 1,
      "prePage": 0,
      "nextPage": 0,
      "isFirstPage": true,
      "isLastPage": true,
      "hasPreviousPage": false,
      "hasNextPage": false,
      "navigatePages": 8,
      "navigatepageNums": [
        1
      ],
      "navigateFirstPage": 1,
      "navigateLastPage": 1
    }
  
    }
    let list = result.data.list;
    let acadeAwards = template('academyAward',list);
    for (let i = 0; i < academyAward.length; i++) {
      academyAward[i].innerHTML = acadeAwards;
    }
});

//--------教师界面的课程大纲的查询按钮实现发送json---------
  //课程介绍
  let form1 = document.getElementById('outline-form1');
  let oBtn1 = document.getElementById('outline-btn1');
  oBtn1.onclick = function () {
    let json1 = {};
    for (let i = 0; i < form1.length - 2; i++) {
      json1[form1[i].name] = form1[i].value;
    }
    console.log("下面是学生课程介绍的查询按钮的出来的json")
    console.log(json1);
  }
  //理论教学大纲
  let form2 = document.getElementById('outline-form2');
  let oBtn2= document.getElementById('outline-btn2');
  oBtn2.onclick = function () {
    let json2 = {};
    for (let i = 0; i < form2.length - 1; i++) {
      json2[form2[i].name] = form2[i].value;
    }
    console.log("下面是学生理论教学大纲的查询按钮的出来的json")
    console.log(json2);
  }
  //考试大纲
  let form3 = document.getElementById('outline-form3');
  let oBtn3= document.getElementById('outline-btn3');
  oBtn3.onclick = function () {
    let json3 = {};
    for (let i = 0; i < form3.length - 1; i++) {
      json3[form3[i].name] = form3[i].value;
    }
    console.log("下面是考试大纲的查询按钮的出来的json")
    console.log(json3);
  }
  //实验教学大纲
  let form4 = document.getElementById('outline-form4');
  let oBtn4= document.getElementById('outline-btn4');
  oBtn4.onclick = function () {
    let json4 = {};
    for (let i = 0; i < form4.length - 1; i++) {
      json4[form4[i].name] = form4[i].value;
    }
    console.log("下面是实验教学大纲的查询按钮的出来的json")
    console.log(json4);
  }
  //教学进度计划表
  let form5 = document.getElementById('plan-form');
  let oBtn5= document.getElementById('plan-btn');
  oBtn5.onclick = function () {
    let json5 = {};
    for (let i = 0; i < form5.length - 1; i++) {
      json5[form5[i].name] = form5[i].value;
    }
    console.log("下面是教学计划进度表的查询按钮的出来的json")
    console.log(json5);
  }

  //---------复选框--------
//课程介绍
let outline1 = document.querySelector('.outline-checkbox-form1');
let outlineCheckBox1 = document.querySelectorAll('.outline-checkbox1');
//先触发点击事件,给表单里的表单元素套循环
for (var i = 0; i < outlineCheckBox1.length; i++) {
  outlineCheckBox1[i].addEventListener('click', () => {
    for (var i = 0; i < outline1.length; i++) {
      //为每一个表单都设置空数组和空json,方便往里头推得到的checkbox的value
      var arr =[];
      var json= {};
      let checkName = outlineCheckBox1[i].name;
      //如果复选框被选中了
      for (var i = 0; i < outlineCheckBox1.length; i++) {
        if(outlineCheckBox1[i].checked){
          arr.push(outlineCheckBox1[i].value);
        }else {}
      }
      json[checkName] = arr;
      console.log(arr);
    }
  });
}
//理论大纲
let outline2 = document.querySelector('.outline-checkbox-form2');
let outlineCheckBox2 = document.querySelectorAll('.outline-checkbox2');
//先触发点击事件,给表单里的表单元素套循环
for (var i = 0; i < outlineCheckBox2.length; i++) {
  outlineCheckBox2[i].addEventListener('click', () => {
    for (var i = 0; i < outline2.length; i++) {
      //为每一个表单都设置空数组和空json,方便往里头推得到的checkbox的value
      var arr =[];
      var json= {};
      let checkName = outlineCheckBox2[i].name;
      //如果复选框被选中了
      for (var i = 0; i < outlineCheckBox2.length; i++) {
        if(outlineCheckBox2[i].checked){
          arr.push(outlineCheckBox2[i].value);
        }else {}
      }
      json[checkName] = arr;
      console.log(arr);
    }
  });
}
//考试大纲
let outline3 = document.querySelector('.outline-checkbox-form3');
let outlineCheckBox3 = document.querySelectorAll('.outline-checkbox3');
//先触发点击事件,给表单里的表单元素套循环
for (var i = 0; i < outlineCheckBox3.length; i++) {
  outlineCheckBox3[i].addEventListener('click', () => {
    for (var i = 0; i < outline3.length; i++) {
      //为每一个表单都设置空数组和空json,方便往里头推得到的checkbox的value
      var arr =[];
      var json= {};
      let checkName = outlineCheckBox3[i].name;
      //如果复选框被选中了
      for (var i = 0; i < outlineCheckBox3.length; i++) {
        if(outlineCheckBox3[i].checked){
          arr.push(outlineCheckBox3[i].value);
        }else {}
      }
      json[checkName] = arr;
      console.log(arr);
    }
  });
}
//实验教学大纲
let outline4 = document.querySelector('.outline-checkbox-form4');
let outlineCheckBox4 = document.querySelectorAll('.outline-checkbox4');
//先触发点击事件,给表单里的表单元素套循环
for (var i = 0; i < outlineCheckBox4.length; i++) {
  outlineCheckBox4[i].addEventListener('click', () => {
    for (var i = 0; i < outline4.length; i++) {
      //为每一个表单都设置空数组和空json,方便往里头推得到的checkbox的value
      var arr =[];
      var json= {};
      let checkName = outlineCheckBox4[i].name;
      //如果复选框被选中了
      for (var i = 0; i < outlineCheckBox4.length; i++) {
        if(outlineCheckBox4[i].checked){
          arr.push(outlineCheckBox4[i].value);
        }else {}
      }
      json[checkName] = arr;
      console.log(arr);
    }
  });
}
//教学进度计划表
let plan = document.querySelector('.plan-checkbox-form');
let planCheckBox = document.querySelectorAll('.plan-checkbox');
//先触发点击事件,给表单里的表单元素套循环
for (var i = 0; i < planCheckBox.length; i++) {
  planCheckBox[i].addEventListener('click', () => {
    for (var i = 0; i < plan.length; i++) {
      //为每一个表单都设置空数组和空json,方便往里头推得到的checkbox的value
      var arr =[];
      var json= {};
      let checkName = planCheckBox[i].name;
      //如果复选框被选中了
      for (var i = 0; i < planCheckBox.length; i++) {
        if(planCheckBox[i].checked){
          arr.push(planCheckBox[i].value);
        }else {}
      }
      json[checkName] = arr;
      console.log(arr);
    }
  });
}
//我的奖项
let award = document.querySelector('.award-checkbox-form');
let awardCheckBox = document.querySelectorAll('.award-checkbox');
//先触发点击事件,给表单里的表单元素套循环
for (var i = 0; i < awardCheckBox.length; i++) {
  awardCheckBox[i].addEventListener('click', () => {
    for (var i = 0; i < award.length; i++) {
      //为每一个表单都设置空数组和空json,方便往里头推得到的checkbox的value
      var arr =[];
      var json= {};
      let checkName = awardCheckBox[i].name;
      //如果复选框被选中了
      for (var i = 0; i < awardCheckBox.length; i++) {
        if(awardCheckBox[i].checked){
          arr.push(awardCheckBox[i].value);
        }else {}
      }
      json[checkName] = arr;
      console.log(arr);
    }
  });
}
})();
