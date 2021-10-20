function incrementValue(vegetable)
{
    var value = parseInt(document.getElementById(vegetable.id+'increase').value);
    if(value >= 0 && value < vegetable.amount)
        value = value+1;
    var result =document.getElementById(vegetable.id+"increase").value = value;
    var result = document.getElementById(vegetable.id+"increase2").value = value;


}
function decrementValue(vegetable)
{
    var value = parseInt(document.getElementById(vegetable.id+'increase').value);
    if(value >= 1)
        value = value-1;
    var result =document.getElementById(vegetable.id+"increase").value = value;
    var result = document.getElementById(vegetable.id+"increase2").value = value;
}