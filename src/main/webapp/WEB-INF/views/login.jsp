<%@include file="blocks/header.jsp" %>

<div id="page-wraper">
    <%@include file="blocks/menu.jsp" %>  
      
      <section class="section contact-me" data-section="section4">
        <div class="container">
          <div class="section-heading">
            <h2>Login User</h2>
            <div class="line-dec"></div>            
          </div>
          <div class="row">
            <div class="right-content">
              <div class="container">
                  
                <form id="contact" action="${path}/web/login" 
                      method="post">
                  <div class="row">
                    <div class="col-md-12">
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
                    <div class="col-md-12">
                      <fieldset>
                        <input
                          name="password"
                          type="password"
                          class="form-control"
                          id="password"
                          placeholder="Password"
                          required
                        />
                      </fieldset>
                    </div>
                    
                    <div class="col-md-12">
                      <fieldset>
                        <button type="submit" id="form-submit" class="button">
                          Login User
                        </button>
                          &nbsp;
                          <sp:if test="${status!=null && status==true}">
                              <b class='text-danger'>Login Done !</b>
                          </sp:if>  
                          <sp:if test="${status!=null && status==false}">
                              <b class='text-danger'>Login Failed !</b>
                          </sp:if>
                          
                          <sp:if test="${vstatus!=null && vstatus==true}">
                              <b class='text-danger'>Please Verify First !</b>
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