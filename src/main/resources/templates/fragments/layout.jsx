import React from 'react';
import PropTypes from 'prop-types';

const Layout = ({ template, menu }) => {
  return (
    <div>
      <head>
        <meta httpEquiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta charSet="utf-8" />
        <meta httpEquiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="shortcut icon" type="image/x-icon" href="/resources/images/favicon.png" />

        <title>PetClinic :: a Spring Framework demonstration</title>

        <link href="/webjars/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="/resources/css/petclinic.css" />
      </head>

      <body>
        <nav className="navbar navbar-expand-lg navbar-dark" role="navigation">
          <div className="container-fluid">
            <a className="navbar-brand" href="/"><span></span></a>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#main-navbar">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="main-navbar">

              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <MenuItem link="/" active={menu === 'home'} title="home page" glyph="home" text="Home" />
                <MenuItem link="/owners/find" active={menu === 'owners'} title="find owners" glyph="search" text="Find owners" />
                <MenuItem link="/vets.html" active={menu === 'vets'} title="veterinarians" glyph="th-list" text="Veterinarians" />
                <MenuItem link="/oups" active={menu === 'error'} title="trigger a RuntimeException to see how it is handled" glyph="exclamation-triangle" text="Error" />
              </ul>
            </div>
          </div>
        </nav>
        <div className="container-fluid">
          <div className="container xd-container">
            {template}

            <br />
            <br />
            <div className="container">
              <div className="row">
                <div className="col-12 text-center">
                  <img src="/resources/images/spring-logo.svg" alt="VMware Tanzu Logo" className="logo" />
                </div>
              </div>
            </div>
          </div>
        </div>

        <script src="/webjars/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
      </body>
    </div>
  );
};

Layout.propTypes = {
  template: PropTypes.node.isRequired,
  menu: PropTypes.string.isRequired,
};

const MenuItem = ({ link, active, title, glyph, text }) => (
  <li className={`nav-item ${active ? 'active' : ''}`}>
    <a className={`nav-link ${active ? 'active' : ''}`} href={link} title={title}>
      <span className={`fa fa-${glyph}`} aria-hidden="true"></span>
      <span>{text}</span>
    </a>
  </li>
);

export default Layout;
