// Markdown 在线编辑器
$(function() {
	var myEditor = editormd("my-editormd", {
		width : "80%",
		height : 740,
		path : 'lib/',
		emoji : true,
		tocm : true,
		tex : true,
		taskList : true,
		codeFold : true,
		flowChart : true,
		syncScrolling : true,
		searchReplace : true,
		sequenceDiagram : true,
		saveHTMLToTextarea : true,
		htmlDecode : "style,script,iframe|on*",
		// theme : "dark",
		// previewTheme : "dark",
		// editorTheme : "pastel-on-dark",
		// previewCodeHighlight : false, // 关闭预览 HTML 的代码块高亮，默认开启
		// dialogLockScreen : false, // 设置弹出层对话框不锁屏，全局通用，默认为true
		// dialogShowMask : false, // 设置弹出层对话框显示透明遮罩层，全局通用，默认为true
		// dialogDraggable : false, // 设置弹出层对话框不可拖动，全局通用，默认为true
		// dialogMaskOpacity : 0.4, // 设置透明遮罩层的透明度，全局通用，默认值为0.1
		// dialogMaskBgColor : "#000", // 设置透明遮罩层的背景颜色，全局通用，默认为#fff

		// 上传图片
		imageUpload : true,
		imageFormats : [ "jpg", "jpeg", "gif", "png", "bmp", "webp", "JPG",
				"JPEG", "GIF", "PNG", "BMP", "WEBP" ],
		imageUploadURL : "/api/images",
		onload : function() {
			console.log('onload', this);
		},
		toolbarIcons : function() {
			return [ "bold", "del", "italic", "quote", "|", "h1", "h2", "h3",
					"h4", "h5", "h6", "|", "list-ul", "list-ol", "hr", "|",
					"link", "image", "code", "code-block", "table", "datetime",
					"html-entities", "emoji", "|", "watch", "preview",
					"fullscreen", "clear", "search", "|", "help", "info" ]
		}
	});
});

// 发布文章
$('#publishBtn').click(function() {
	console.log("publish()");
	$.ajax({
		type : "POST",
		url : "/api/article",
		traditional : true, // 传数组
		data : {
			"title" : $('#title').val(),
			"content" : myEditor.getHTML()
		},
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json",
		success : function(data) {
			console.log("success");
		},
		error : function() {
			console.log("fail");
			alert("发布失败！");
		}
	});
});
