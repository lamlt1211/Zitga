function validateNotNull(inputText)
{
    var empty =" ";
    return re.test(notNull);
}
function validate1() {
  var $result = $("#result");
  var notNull = $("#notNull").val();
  $result.text("");
  if (validateNotNull(notNull)) {
        $result.text(notNull + " is not null :(");
        $result.css("color", "red");
  }
  return false;
}

function validateNumber(inputText){
    var $result = $("#result");
    var number = document.getElementById("price").value;
    if(isNaN(number)){
        $result.text(number+ " is not Number :(");
        $result.css("color", "red");
    }
}

function validateListBox()
{
    var ListBoxObject=document.getElementById("categoryIds")
    var tot=0;

    for (var i = 0;i < ListBoxObject.length; i++)
    {
        if (ListBoxObject.options[i].selected == false)
            {tot=tot+1;}
    }

    if (ListBoxObject.length==tot)
    {
        alert('Please select fruits from a list')
        return false;
    }

}

$("#categoryName").on("click", validate1);
$("#productName").on("click", validate1);
$("#price").on("click", validateNumber);
$("#categoryIds").on("click", validateListBox);