<%@include file="blocks/header.jsp" %>

<div id="page-wraper">
    <%@include file="blocks/menu.jsp" %>  
      
      <section class="section contact-me" data-section="section4">
        <div class="container">
          <div class="section-heading">
            <h2>Register User</h2>
            <div class="line-dec"></div>            
          </div>
          <div class="row">
            <div class="right-content">
              <div class="container">
                  
                <form id="contact" action="${path}/user/save" 
                      method="post">
                  <div class="row">
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="userName"
                          type="text"
                          class="form-control"
                          id="name"
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
                          id="email"
                          placeholder="Your email..."
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="userPassword"
                          type="password"
                          class="form-control"
                          id="password"
                          placeholder="Password"
                          required
                        />
                      </fieldset>
                    </div>
                      <div class="col-md-6">
                      <fieldset>
                        <select
                          name="userBloodGroup"
                          class="form-control"
                          id="bg"required
                        >
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
                      </fieldset>
                    </div>
                   
                    <div class="col-md-12">
                      <fieldset>
                        <button type="submit" id="form-submit" class="button">
                          Save User
                        </button>
                          &nbsp;
                          <sp:if test="${status!=null && status==true}">
                              <b class='text-danger'>Registeration Done !</b>
                          </sp:if>  
                          <sp:if test="${status!=null && status==false}">
                              <b class='text-danger'>Registeration Failed !</b>
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
<%@include file="blocks/footer.jsp" %>