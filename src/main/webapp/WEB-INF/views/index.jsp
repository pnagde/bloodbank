<%@include file="blocks/header.jsp" %>

<div id="page-wraper">
    <%@include file="blocks/menu.jsp" %>  
      <section class="section about-me" data-section="section1">
        <div class="container">
          <div class="section-heading">
            <h2>About Me</h2>
            <div class="line-dec"></div>
            <span
              >Blood banking refers to the process of collecting, separating, and storing blood. </span
            >
          </div>
          <div class="left-image-post">
            <div class="row">
              <div class="col-md-6">
                <div class="left-image">
                  <img src="${path}/assets/images/left-image.jpg" alt="" />
                </div>
              </div>
              <div class="col-md-6">
                <div class="right-text">
                  
                  <p>
                    Blood is the vital connection to having a healthy body, and according to the American Red Cross, nearly 5 million people receive blood transfusions each year. Thanks to years of research, much progress has been made towards making transfusions safer and more effective.
                  </p>                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>

      
      <section class="section contact-me" data-section="section4">
        <div class="container">
          <div class="section-heading">
            <h2>Contact Me</h2>
            <div class="line-dec"></div>            
          </div>
          <div class="row">
            <div class="right-content">
              <div class="container">
                <form id="contact" action="" method="post">
                  <div class="row">
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="name"
                          type="text"
                          class="form-control"
                          id="name"
                          placeholder="Your name..."
                          required=""
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-6">
                      <fieldset>
                        <input
                          name="email"
                          type="text"
                          class="form-control"
                          id="email"
                          placeholder="Your email..."
                          required=""
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-12">
                      <fieldset>
                        <input
                          name="subject"
                          type="text"
                          class="form-control"
                          id="subject"
                          placeholder="Subject..."
                          required=""
                        />
                      </fieldset>
                    </div>
                    <div class="col-md-12">
                      <fieldset>
                        <textarea
                          name="message"
                          rows="6"
                          class="form-control"
                          id="message"
                          placeholder="Your message..."
                          required=""
                        ></textarea>
                      </fieldset>
                    </div>
                    <div class="col-md-12">
                      <fieldset>
                        <button type="submit" id="form-submit" class="button">
                          Send Message
                        </button>
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