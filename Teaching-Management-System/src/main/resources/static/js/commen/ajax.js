 // 用来发送网络请求的函数  会调用就行
 function ajax(options) {
  // 格式话参数
  function formsParams(data) {
    var arr = [];
    for (var prop in data) {
      arr.push(prop + '=' + data[prop]);
    }
    return arr.join('&');
  }
  //这个options时传入给ajax的配置参数
  return new Promise((resolve, reject) => {
    //返回一个promise对象 resolve成功是的处理，reject失败时的处理
    if (!options.url) {
      // 需要请求的路径
      console.log('请确认你的url路径');
      return;
    }
    let method = options.method || 'GET'; //请求方式如果没有就默认为get
    let async = options.async || true; //ajax是否异步请求默认位true
    let xhr = new XMLHttpRequest();
    if (method === 'GET') {
      xhr.open(method, options.url + '?' + Math.random(), async); //防止缓存
      options.token && xhr.setRequestHeader('authorization', `Bearer ${options.token}`);
      xhr.send(null);
    } else if (method === 'POST') {
      xhr.open(method, options.url, async);
      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.send(formsParams(options.data));
    }

    xhr.onreadystatechange = () => {
      if (xhr.responseText) {
        //有数据说明相应成功
        resolve(xhr.responseText);
      }
    };
    xhr.onerror = (err) => {
      reject(err);
    };
  }).catch((e) => {});
}
