<%@include file="blocks/header.jsp" %>


<div id="page-wraper">
    <%@include file="blocks/usermenu.jsp" %>  
      
      <section class="section contact-me" data-section="section4">
        <div class="container">
          <div class="section-heading">
            <h2>Blood Request</h2>
            <div class="line-dec"></div>            
          </div>
            
           
            
          <div class="row">
            <div class="right-content">
              <div class="container">
                 
                <form id="contact" 
                      action="${path}/user/saverequest" 
                      method="post">
                  <div class="row">
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="personName"
                          type="text"
                          class="form-control"
                          id="name"
                          placeholder="Person Name..."
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="contact"
                          type="text"
                          class="form-control"
                          id="contact"
                          placeholder="Your Contact..."
                          required
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                          <input
                          name="location"
                          type="text"
                          class="form-control"
                          id="location"
                          placeholder="Location ..."
                          required
                        />
                      </fieldset>
                    </div>
                      <div class="col-md-6">
                      <fieldset>
                        <select
                          name="bloodgroup"
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
                          Save Request
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
          <br>          
          <table class='table table-striped'>
              <thead>
                  <tr>
                      <th>Blood Group</th>
                      <th>Person Name</th>
                      <th>Contact</th>
                      <th>Location</th>
                      <th>Date</th>
                      <th>Sender</th>
                  </tr>
              </thead>
              <tbody>
                  <sp:forEach items="${requests}" var="reqob">
                      <tr>
                          <td>${reqob.bloodgroup}</td>
                          <td>${reqob.personName}</td>
                          <td>${reqob.contact}</td>
                          <td>${reqob.location}</td>
                          <td>${reqob.sendDate}</td>
                          <td>${reqob.requestSender.userName}</td>
                      </tr>
                  </sp:forEach>
              </tbody>
          </table>
                      
                      
        </div>
      </section>
    </div>
<%@include file="blocks/footer.jsp" %>