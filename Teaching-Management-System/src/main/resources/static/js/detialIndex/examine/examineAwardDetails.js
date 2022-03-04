window.addEventListener("load", function() {

    let result = {
        "code": 200,
        "msg": "OK",
        "data": {
            "pizId": 1,
            "ptime": "2022-02-09T01:21:59.000+00:00",
            "pwinner": "张三",
            "psponsor": "河南财政金融学院",
            "plevel": "A",
            "level": "一等奖",
            "category": 1,
            "title": "1",
            "number": "201900001",
            "pname": "ACM",
            "tid": "2",
            "tname": "老赵,黄老师,李老师",
            "pathFront": "/img/a.png,/img/b.png,/img/c.png",
            "createTime": "2022-02-09T01:24:24.000+00:00",
            "modifiedTime": "2022-02-09T01:24:26.000+00:00",
            "uid": 1,
            "faculty": "河南财政金融学院",
            "grade": "2019",
            "status": 0,
            "reason": null,
            "auditId": null,
            "isDelete": null
        }
    };
    let List = result.data;
    console.log(List);
    // 奖状图片路径处理 "pathFront": "/img/a.png,/img/b.png,/img/c.png" 
    // let pathFront = List.pathFront;
    // console.log(pathFront);
    let pathFronts = List.pathFront.split(',');
    console.log(pathFronts); //形成数组
    List.pathFront = pathFronts;
    console.log(List);

    // ------------------奖状图片预览---------------------------------------
    let awardmessage = document.querySelector('#examineAward');
    let awardTbody = template('examineaward', List);
    awardmessage.innerHTML = awardTbody;

    let awadeInfoBtn = document.querySelectorAll('#btn-img');
    let awadeInfo = document.querySelectorAll('#box-img');
    console.log(awadeInfo);
    for (let i = 0; i < awadeInfoBtn.length; i++) {
        awadeInfoBtn[i].onclick = function(ev) {
            let oEvent = ev || window.event;
            oEvent.cancelBubble = true;
            oEvent.preventDefault();
            console.log(1);
            for (let j = 0; j < awadeInfo.length; j++) {
                awadeInfo[j].style.display = 'none';
            }
            awadeInfo[i].style.display = 'block';

        };
        document.addEventListener('click', () => {
            for (let i = 0; i < awadeInfo.length; i++) {
                awadeInfo[i].style.display = 'none';
            }
        })

    }


    // 获取selector选中的内容
    var reason = document.querySelector("#selector");
    // 获取textarea
    var content = document.querySelector(".content");
    var Send1 = "请确定是否审批为通过";
    var Send2 = "请确定是否审批为不通过";

    let pass = document.querySelector('#btn-success');
    let noPass = document.querySelector('#btn-fail');

    function Send(param) {
        var flag = confirm(param);
        return flag;

    }
    // 给下拉框添加监听事件
    let flags = true;
    reason.addEventListener('change', function() {
        let ss = reason.options[this.selectedIndex].innerText;
        // let reg = `/${ss}/ig`;
        // console.log(reg);
        let reg = eval('/' + ss + '/ig'); //正则
        // console.log(reg);
        if (reg.test(content.value)) {
            alert("理由重复,请选择其他理由");
            return;
        } else if (!reg.test(content.value) && ss != '请选择不通过理由') {
            if (flags) {
                content.value += ss;
                flags = false;
                noPass.addEventListener('click', function(e) {
                    var flag = Send(Send2);
                    // close();
                    if (flag) {
                        request
                            .get('/manangmentSystem/verify/successPrize', {
                                pizId: 1,
                                auditId: '001',
                                resaon: content.value,
                            })
                            .then((res) => {
                                console.log(res);
                                console.log(content.value);
                            });
                    }
                    close();
                });
            } else {
                content.value += "," + ss;
                noPass.addEventListener('click', function(e) {
                    var flag = Send(Send2);

                    if (flag) {
                        request
                            .get('/manangmentSystem/verify/successPrize', {
                                pizId: 1,
                                auditId: '001',
                                resaon: content.value,
                            })
                            .then((res) => {
                                console.log(res);
                                console.log(content.value);
                            });
                        close();
                    }

                });
            }
            // close();
        }

    })

    pass.addEventListener('click', function(e) {
        var flag = Send(Send1);
        if (flag) {
            request
                .get('/manangmentSystem/verify/successPrize', {
                    pizIdList: 2,
                    auditId: 2
                })
                .then((res) => {
                    console.log(res);
                });
        }
        close();
    });




})