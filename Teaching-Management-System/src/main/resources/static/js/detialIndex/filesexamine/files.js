window.addEventListener('load', function() {
    // 人才培养方案模块
    let trainingResult = {
        "code": 200,
        "msg": "OK",
        "data": {
            "did": 1,
            "path": "../../../../static/js/detialIndex/PDF/compressed.tracemonkey-pldi-09.pdf",
            "size": 120,
            "fileName": "人才培养方案",
            "fileType": 30,
            "createTime": "2022-02-09T01:19:48.000+00:00",
            "modifiedTime": "2022-02-09T01:19:51.000+00:00",
            "grade": "2019",
            "semester": 8,
            "faculty": "计算机与信息技术学院",
            "major": "计算机科学与技术专业",
            "uid": 1,
            "status": 0,
            "reason": null,
            "auditId": null,
            "course": "",
            "level": 1
        }
    };


    function trans(n) {
        let str = '';

        if (n == 20) {
            str = '教学计划表';
        } else if (n == 30) {
            str = '人才培养方案';
        } else if (n = 10) {
            str = '课程介绍';
        } else if (n = 11) {
            str = '理论教学大纲'
        } else if (n == 12) {
            str = '考试大纲';
        } else if (n == 13) {
            str = '实验教学大纲';
        }
        return str;
    }
    let trainingfile = trainingResult.data;
    trainingfile.fileType = trans(trainingfile.fileType);
    let infop = document.querySelector('.trainingfiles');
    let htmlp = template('trainingfiles', trainingfile);
    infop && (infop.innerHTML = htmlp);


    // 课程大纲，课程介绍，理论教学大纲，验教学大纲，考试大纲，教学进度计划表  模块
    let otherResult = {
        "code": 200,
        "msg": "OK",
        "data": {
            "did": 1,
            "path": "../../../../static/js/detialIndex/PDF/compressed.tracemonkey-pldi-09.pdf",
            "size": 120,
            "fileName": "java程序设计",
            "fileType": 11,
            "createTime": "2022-02-09T01:19:48.000+00:00",
            "modifiedTime": "2022-02-09T01:19:51.000+00:00",
            "grade": "2019",
            "semester": 8,
            "faculty": "计算机与信息技术学院",
            "major": "计算机科学与技术专业",
            "uid": 1,
            "status": 0,
            "reason": null,
            "auditId": null,
            "course": "",
            "level": 1
        }
    };

    let otherfiles = otherResult.data;
    otherfiles.fileType = trans(otherfiles.fileType);
    let infoo = document.querySelector('.otherfiles');
    let htmlo = template('otherfiles', otherfiles);
    infoo && (infoo.innerHTML = htmlo);

    //通过不通过按钮处理
    let pass = document.querySelector('.pass');
    pass.addEventListener('click', function() {
        var flag = confirm('请确定是否为通过');
        if (flag) {
            close();
            // 以下为异步代码区域
        } else {
            close();

            // 以下为异步代码区域
        }
    });
    let nopass = document.querySelector('.nopass');
    nopass.addEventListener('click', function() {
        var flags = confirm('请确定是否为不通过');
        if (flags) {
            close();
            // 以下为异步代码区域
        } else {
            close();

            // 以下为异步代码区域
        }

    });
})