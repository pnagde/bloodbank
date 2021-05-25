<%@include file="blocks/header.jsp" %>


<div id="page-wraper">
    <%@include file="blocks/usermenu.jsp" %>  
      
      <section class="section contact-me" data-section="section4">
        <div class="container">
          <div class="section-heading">
            <h2>User Home</h2>
            <div class="line-dec"></div>            
          </div>
            
            <select  class="form-control"
                          id="bgroup">
                        <option value=''>Choose Blood Group</option>
                        <option>A+</option>
                        <option>A-</option>
                        <option>B+</option>
                        <option>B-</option>
                        <option>O+</option>
                        <option>O-</option>
                        <option>AB+</option>
                        <option>AB-</option>
                        </select>   
            
            <br>
                 
               <table class='table table-striped'>
                   <thead>
                       <tr>
                           <th>User Name</th>
                           <th>Phone</th>
                           <th>Email</th>
                           <th>Gender</th>
                           <th>DOB</th>
                       </tr>
                   </thead>
                   <tbody id='tb'>
                       
                   </tbody>
               </table>
                
             
        </div>
      </section>
    </div>
<%@include file="blocks/footer.jsp" %>