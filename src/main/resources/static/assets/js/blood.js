$("#bgroup").change(function()
{
    var group = $(this).val();
    
    var url = serverpath + "/user/search";
    $.post(url,{bloodgroup:group},function(data,status)
    {
        var arr = JSON.parse(data);
        console.log(data);
        var finalTR="";
        
        for(var x = 0;x<arr.length;x++)
        {
            var ob = arr[x];
            
            var tr = "<tr>";
            tr += "<td>"+ob.userName+"</td>";
            tr += "<td>"+ob.userPhone+"</td>";
            tr += "<td>"+ob.userEmail+"</td>";
            tr += "<td>"+ob.userGender+"</td>";
            tr += "<td>"+ob.userDOB+"</td>";            
            tr += "</tr>";
            
            finalTR+=tr;
        }
        $("#tb").html(finalTR);
    });
});