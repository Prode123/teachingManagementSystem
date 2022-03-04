window.addEventListener('load', function() {
    console.log(888);
    //做选项卡：把原有样式去掉，再加上新的样式
    //先给俩标签获取到，做它们俩来回切换的JavaScript
    var aLi = document.querySelectorAll('#navteach li');
    // console.log(aLi);
    var aDiv = document.querySelectorAll('#addboxs');
    //整一个一眼就能看出来当前标签页是哪个的效果
    for (var i = 0; i < aLi.length; i++) {
        //鼠标点击的时候加上背景色
        aLi[i].index = i; //使用变量index存储当前的下标
        aLi[i].onclick = function() {
            //首先去掉所有样式
            for (var i = 0; i < aLi.length; i++) {
                //让标签页去掉颜色
                aLi[i].classList.remove('teach-bgc');
                aDiv[i].classList.remove('boxshow');
            }
            this.classList.add('teach-bgc');
            //给对应的盒子加上boxshow，使他们出现
            aDiv[this.index].classList.add('boxshow');
        };
    }

    // 获取节点
    var addcontent = document.getElementById('addcontent');
    var btn = document.getElementById('tea-add');
    var span2 = document.querySelector('.closes ');
    //创建点击事件
    btn.onclick = function() {
        addcontent.style.display = 'block';
    };
    span2.onclick = function() {
        addcontent.style.display = 'none';
    };
    // 在用户点击其他地方时，关闭弹窗
    window.onclick = function(event) {
        if (event.target == addcontent) {
            addcontent.style.display = 'none';
        }
    };


    let checkRole = document.querySelector('.checkRole');
    checkRole.onchange = function() {
        this.style.background = 'rgb(232,240,255)';
    }

    // 选择角色


    let selectrole = document.querySelector('#roleId'); //复选框选中后所放位置
    let arr = document.querySelectorAll('input[name="role"]'); //复选框input
    let str = '';
    let str1 = ['普通教师', '课程负责人', '教研室主任'];
    let inputids = '';
    for (let i = 0; i < arr.length; i++) {
        arr[i].onclick = function() {
            if (this.checked) {
                str.length === 0 ? (str += str1[i]) : (str += ',' + str1[i]);
                inputids.length === 0 ? (inputids += i + 1) : (inputids += ',' + (i + 1));
            } else {
                str = str.replace(str1[i] + ',', '');
                str = str.replace(',' + str1[i], '');
                str = str.replace(str1[i], '');
                inputids = inputids.replace(i + 1 + ',', '');
                inputids = inputids.replace(',' + (i + 1), '');
                inputids = inputids.replace(i + 1, '');
            }
            selectrole.value = str.trim();
            // console.log(inputids);
        };
    }


    //批量添加上传文件（传统的input的file类型）
    let filess = document.querySelector('#filess');
    let filessName = document.querySelector('.filless-name');
    let statuss = document.querySelector('.statuss');
    let formdate = new FormData();
    filess.addEventListener('change', function() {

        let file = filess.files[0];
        if (!file.name.endsWith('.xlsx')) {
            alert('文件类型错误请重新上传');
            return;
        }
        filessName.innerHTML = file.name;
        // console.log(file);
        formdate.append(file.name, file);

        if (file) {
            statuss.innerHTML = '上传成功';
        } else {
            statuss.innerHTML = '';

        }

    });
    // 批量添加后打包文件

    let addbtn4 = document.querySelector('#teach-addmessages'); // 批量添加按钮
    addbtn4.onclick = function() {
            // request.post('/manangmentSystem/admin/batchAddUsers', formdate, {
            //     headers: { 'Content-Type': 'multipart/form-data' }
            // });
            var flag = confirm('请确定是否添加');
            // 以下为异步代码区域

        }
        // 单个添加
    let addbtn3 = document.querySelector('#teach-addmessage');

    // 获取单个添加的表单
    let formteach = document.querySelector('#form2');
    // console.log(formteach);
    addbtn3.addEventListener('click', () => {
        // 单个添加的json
        let teachjson = {};
        var flag = confirm('请确定是否添加');
        let arrcheck = [];
        let checkname = document.querySelector('input[name="roleId"]').name;

        for (var i = 0; i < formteach.length - 1; i++) {
            if (formteach[i].type == 'radio' && !formteach[i].checked) {
                continue;
            } else
            if (formteach[i].type == 'checkbox' && formteach[i].checked) {
                arrcheck.push(formteach[i].value);
            } else {
                console.log(formteach[i].value);
                teachjson[formteach[i].name] = formteach[i].value;
            }
        }
        teachjson[checkname] = arrcheck;
        console.log(arrcheck);
        console.log(teachjson);
        // 以下为单个添加用户信息的异步代码区域(弹出提示是否确定修改后，点击确定将teachjson给后端)

    })




});