window.addEventListener('load', function() {
    // console.log(222);
    //做选项卡：把原有样式去掉，再加上新的样式
    //先给俩标签获取到，做它们俩来回切换的JavaScript
    var aLis = document.querySelectorAll('#nav li');
    console.log(aLis);
    var aDivs = document.querySelectorAll('#addbox');
    //整一个一眼就能看出来当前标签页是哪个的效果
    for (var i = 0; i < aLis.length; i++) {
        //鼠标点击的时候加上背景色
        aLis[i].index = i; //使用变量index存储当前的下标
        aLis[i].onclick = function() {
            //首先去掉所有样式
            console.log(111);
            for (var i = 0; i < aLis.length; i++) {
                //让标签页去掉颜色
                aLis[i].classList.remove('ul-bgc');
                aDivs[i].classList.remove('addshow');
            }
            this.classList.add('ul-bgc');
            //给对应的盒子加上addshow，使他们出现
            aDivs[this.index].classList.add('addshow');
        };
    }


    // 获取节点
    var addboxcontent = document.getElementById('addboxcontent');
    // var btn = document.getElementById("open");
    var addbtn = document.getElementById('stu-add');

    var span1 = document.querySelector('.close');
    console.log(addbtn);
    //创建点击事件
    addbtn.onclick = function() {
        let formstu = document.querySelector('#form1');
        // for (var i = 0; i < formstu.length - 1; i++) {
        //     formstu[i].value = '';
        // }
        addboxcontent.style.display = 'block';
        // addboxcontent.innerHTML = '';
    };
    span1.onclick = function() {
        addboxcontent.style.display = 'none';
    };
    // 在用户点击其他地方时，关闭弹窗
    window.onclick = function(event) {
        if (event.target == addboxcontent) {
            addboxcontent.style.display = 'none';
        }
    };


    // ------------------批量添加---------------------
    let addbtn2 = document.querySelector('#stu-addmessages');
    const files = document.querySelector('#files');
    const filesName = document.querySelector('.filles-name');
    let status = document.querySelector('.status');
    let formdate = new FormData();
    files.addEventListener('change', function() {
        let file = files.files[0];
        if (!file.name.endsWith('.xlsx')) {
            alert('文件类型错误请重新上传');
            return;
        }
        filesName.innerHTML = file.name;
        console.log(file);
        formdate.append(file.name, file);
        if (file) {
            status.innerHTML = '上传成功';
        } else {
            status.innerHTML = '';
        }
    });

    // 获取批量添加的文件
    addbtn2.onclick = function() {
        // request.post('/manangmentSystem/admin/batchAddUsers', formdate, {
        //     headers: { 'Content-Type': 'multipart/form-data' }
        // });
        var flag = confirm('请确定是否添加');
        if (flag) {

        }

    }

    // --------------------单个添加----------------------
    let addbtn1 = document.querySelector('#stu-addmessage');

    // 获取单个添加的表单
    let formstu = document.querySelector('.formStudent');
    console.log(formstu.length);
    let stujson = {};

    addbtn1.addEventListener('click', function() {
        var flag = confirm('请确定是否添加');
        console.log('a');
        for (let k = 0; k < formstu.length - 1; k++) {
            console.log('b');
            console.log(formstu[k].type);
            if (formstu[k].type == 'radio' && !formstu[k].checked) {

                console.dir(formstu[k]);
                console.log(formstu[k].id);
                // continue;
            } else {
                stujson[formstu[k].name] = formstu[k].value;
            }
        }
        // roleId:"0")
        stujson.roleId = "0";
        console.log(stujson);
        // 以下为异步代码区域（确定添加时将stujson给后端）

    });

});