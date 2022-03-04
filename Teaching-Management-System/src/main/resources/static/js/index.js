window.onload = function () {
  var btn = document.querySelector('.login-content-submit');
  var code = '';

  //用icon替换小眼睛
  var aEye = document.querySelectorAll('.eye');
  var aType = document.querySelectorAll('.update-form input[type="password"]');
  // alert(aEye.length);
  for (var i = 0; i < aEye.length; i++) {
    var flag = 0;
    aEye[i].index = i;
    aEye[i].onclick = function () {
      if (flag == 0) {
        aType[this.index].type = 'text';
        // this.src = '../../../static/img/hide.svg';
        this.classList.remove('icon-yincangmima');
        this.classList.add('icon-mimaxianshi');
        // this.th:src = '@{/img/hide.svg'}';// 这个是不行的
        flag = 1;
      } else if (flag == 1) {
        aType[this.index].type = 'password';
        // this.src = '../../../static/img/show.svg';
        this.classList.remove('icon-mimaxianshi');
        this.classList.add('icon-yincangmima');
        flag = 0;
      }
    };
  }

  const canvas = document.querySelector('canvas'); //选中canvas元素
  const ctx = canvas.getContext('2d'); //创建canvas画布

  //生成最大为max的随机整数
  function createRandomNumber(max, min = 0) {
    const range = max - min;
    const randomNum = Math.round(Math.random() * range) + min;
    return randomNum;
  }

  //生成透明度为opacity(为保证清晰，不得大于1小于0.4)的颜色
  function createRandomColor(opacity) {
    return `rgba(${createRandomNumber(255)},${createRandomNumber(255)},${createRandomNumber(255)},${
      opacity < 0.4 ? 0.4 : opacity > 1 ? 1 : opacity
    })`;
  }

  //生成具有随机位置的干扰点
  function createDot() {
    const xPosition = createRandomNumber(canvas.width);
    const yPosition = createRandomNumber(canvas.height);
    const color = createRandomColor(0.6);

    ctx.beginPath();
    ctx.arc(xPosition, yPosition, 2, 0, Math.PI * 2, false);
    ctx.fillStyle = color;
    ctx.strokeStyle = color;
    ctx.fill();
    ctx.stroke();
    ctx.closePath();
  }

  //生成具有随机位置随机颜色的干扰线
  function createLine() {
    const color = createRandomColor(1);

    ctx.beginPath();
    ctx.moveTo(0, createRandomNumber(canvas.height));
    ctx.lineTo(canvas.width, createRandomNumber(canvas.height));
    ctx.strokeStyle = color;
    ctx.stroke();
    ctx.closePath();
  }

  //生成具有随机颜色的随机大写字母
  function createText(word) {
    // const xPosition = createRandomNumber(canvas.width - 60) + 30;
    // const yPosition = createRandomNumber(canvas.height - 60) + 30;
    const xPosition = 58;
    const yPosition = 10;
    const color = createRandomColor(1);
    const text = String.fromCharCode(createRandomNumber(65, 90));
    ctx.font = "bold 23px '黑体'";
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    ctx.fillStyle = color;
    ctx.fillText(word, xPosition, yPosition);
  }

  function codeToCanvas(word) {
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    for (let num = 1; num <= 15; num++) {
      createDot();
      if (num <= 3) {
        createLine();
      }
    }
    createText(word);
  }

  canvas.addEventListener('click', () => {
    getCode();
    codeToCanvas(code);
  });

  // 获取验证码
  let verificationEl = document.querySelector('#verification');
  function getCode() {
    request.get('/manangmentSystem/user/getCode').then((res) => {
      console.log('验证码', res);
      let { verifyCode } = res.data.data;
      codeToCanvas(verifyCode);
      code = verifyCode;
      // 自动输入验证码
      verificationEl.value = verifyCode;
    });
  }
  getCode();
  // 登录
  const username = document.querySelector('#username');
  const password = document.querySelector('#password');
  btn.addEventListener('click', (e) => {
    var codeEl = document.querySelector('#verification');
    if (codeEl.value === code) {
      request
        .request({
          url: `/manangmentSystem/user/tologin?number=${username.value}&passwd=${password.value}`,
          method: 'POST',
          timeout: 3000,
        })
        .then((res) => {
          res = res.data.data;
          if (res.originalUserDB.number == username.value) {
            console.log('登录成功', res);
            localStorage.setItem('profile', JSON.stringify(res));
            if (res.originalUserDB.roleId == 0) {
              // location.href = '../templates/page/studentIndex/index.html';
              location.href = 'studentIndex.html';
            } else if (res.originalUserDB.roleId == 1) {
              // location.href = '../templates/page/teacherIndex/index.html';
              location.href = 'teacherIndex.html';
            } else if (res.originalUserDB.roleId == 2) {
              // location.href = '../templates/page/adminIndex/index.html';
              location.href = 'adminIndex.html';
            } else if (res.originalUserDB.roleId == 3) {
              // location.href = '../templates/page/superAdminIndex/index.html';
              location.href = 'superAdminIndex.html';
            } else {
              alert('类型错误,暂时跳转到studetIndex');
              location.href = '../templates/page/studentIndex/index.html';
            }
          } else {
            alert('账号或密码错误,登录失败');
          }
        });
    } else {
      alert('验证码错误');
      code = '';
      getCode();
    }
  });
};
