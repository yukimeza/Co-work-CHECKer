$('#myImage').on('change', function (e) {
    var reader = new FileReader();
    reader.onload = function (e) {
        $("#preview").attr('src', e.target.result);
    }
    reader.readAsDataURL(e.target.files[0]);
});



function previewImage(obj)
{
  var fileReader = new FileReader();
  fileReader.onload = (function() {
    document.getElementById('preview').src = fileReader.result;
  });
  fileReader.readAsDataURL(obj.files[0]);
}