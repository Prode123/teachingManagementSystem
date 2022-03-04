window.addEventListener('load',function(){
	var aSpan = document.querySelectorAll('.tab-manage');
	//再获取到俩装着表格的div
	var aDiv = document.querySelectorAll('.wrapper-div-table');
	//整一个一眼就能看出来当前标签页是哪个的效果
	for (var i = 0; i < aSpan.length; i++) {
		//鼠标点击的时候加上背景色
		aSpan[i].index = i;//使用变量index存储当前的下标
		aSpan[i].onclick = function(){
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
		}
	}

	//点击文字上传
	var aBtn = document.querySelectorAll('.form-upload-file');
	for (var i = 0; i < aBtn.length; i++) {
		aBtn[i].index = i;
		aBtn[i].onclick = function(){
			document.querySelectorAll('.form-file')[this.index].click();
		}
	}

	//全选框事件
	var aCheckAll = document.querySelectorAll('#checkAll');
	//全选框事件：选中tbody标签下的所有复选框
	var aCheckBox = document.querySelectorAll('#checkBox');

	//点击全选按钮之后触发全选事件：把当前的全选框状态赋值给所有复选框
	for (var i = 0; i < aCheckAll.length; i++) {
	    aCheckAll[i].index = i;
	    aCheckAll[i].onclick = function() {
	        var aCheckBox_input = aCheckBox[this.index].querySelectorAll('input');
	        var this_ = this;
	        for (var i = 0; i < aCheckBox_input.length; i++) {
	            aCheckBox_input[i].checked = this.checked;
	        }
	        for (var i = 0; i < aCheckBox_input.length; i++) {
	            aCheckBox_input[i].onclick = function() {
	                flag = true;
	                for (var i = 0; i < aCheckBox_input.length; i++) {
	                    if (!aCheckBox_input[i].checked) {
	                        flag = false;
	                        break;
	                    }
	                }
	                aCheckAll[this_.index].checked = flag;
	            }
	        }
	    }
	}
});
