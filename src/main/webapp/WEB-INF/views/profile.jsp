<%@include file="blocks/header.jsp" %>

<div id="page-wraper">
    <%@include file="blocks/usermenu.jsp" %>  
      
      <section class="section contact-me" data-section="section4">
        <div class="container">
          <div class="section-heading">
            <h2>Update User</h2>
            <div class="line-dec"></div>            
          </div>
          <div class="row">
            <div class="right-content">
              <div class="container">
                  
                <form id="contact" action="${path}/user/update" 
                      method="post">
                      <input type='hidden' name="userId" value="${user.userId}">
                  <div class="row">
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="userName"
                          type="text"
                          class="form-control"
                          id="name" value="${user.userName}"
                          placeholder="Your name..."
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="userEmail"
                          type="text"
                          class="form-control"
                          id="email" value="${user.userEmail}"
                          placeholder="Your email..."
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="userPhone"
                          type="text"
                          class="form-control"
                          id="phone" value="${user.userPhone}"
                          placeholder="Phone"
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="userDOB"
                          type="date"
                          class="form-control"
                          id="dob" value="${user.userDOB}"
                          placeholder="DOB"
                          required
                        />
                      </fieldset>
                    </div>
                    
                    <div class="col-md-6">
                      <fieldset>
                        <select
                          name="userGender"                          
                          class="form-control"
                          id="gender">
                          <option value=''>Choose Gender</option>
                          <option>Male</option>
                          <option>Female</option>
                          </select>
                      </fieldset>
                    </div>
                   
                    <div class="col-md-6">
                      <fieldset>
                        <button type="submit" id="form-submit" class="button">
                          Update User
                        </button>
                          &nbsp;
                          <sp:if test="${status!=null && status==true}">
                              <b class='text-danger'>Update Done !</b>
                          </sp:if>  
                          <sp:if test="${status!=null && status==false}">
                              <b class='text-danger'>Update Failed !</b>
                          </sp:if>  
                      </fieldset>
                    </div>
                  </div>
                </form>
                
                <div class="section-heading">
                <h2>Change Password</h2>
            	<div class="line-dec"></div> 
            	</div>
            	
            	<form id="contact" action="${path}/user/changepass" 
                      method="post">
                  <div class="row">
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="oldpass"
                          type="password"
                          class="form-control"
                          id="old"
                          placeholder="Old Password.."
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="newpass"
                          type="password"
                          class="form-control"
                          id="newpass"
                          placeholder="New Password.."
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <button type="submit" id="form-submit" class="button">
                          Change Password
                        </button>
                        &nbsp;
                        <sp:if test="${cpstatus!=null && cpstatus==false}">
                        	<b class='text-danger'>Change Password Failed !</b>
                        </sp:if>
                        </fieldset>
                        </div>
                </div>
                </form>
            	
            	   
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
    
    <script>
    	$("#gender").val('${user.userGender}');
    </script>
<%@include file="blocks/footer.jsp" %>