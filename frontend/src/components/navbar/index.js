
import './styles.css'




const Navbar = () => {
    return(
	<>

{/* <nav class="navbar navbar-expand-lg navbar-dark" >
  <a class="navbar-brand" href="#">Navbar</a>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto"></ul>
    <form class="form-inline my-2 my-lg-0 mx-auto">
      <div class="input-group">
        <input class="form-control" type="search" placeholder="Search" aria-label="Search"/>
        <div class="input-group-append">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </div>
      </div>
    </form>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="ml-auto mr-1">
      <button type="button" class="btn btn-danger">Login</button>
    </div>
    <div>
      <button type="button" class="btn btn-danger">Register</button>
    </div>
  </div>
</nav>
     */}
     {/* <nav class="navbar navbar-expand-lg navbar-dark">
  <a class="navbar-brand" href="#">Navbar</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto"></ul>
    <form class="form-inline my-2 my-lg-0 mx-auto">
      <div class="input-group">
        <input class="form-control" type="search" placeholder="Search" aria-label="Search" />
        <div class="input-group-append">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </div>
      </div>
    </form>

    <div class="ml-auto mr-1">
      <button type="button" class="btn btn-danger">Login</button>
      <button type="button" class="btn btn-danger">Register</button>
    </div>
  </div>
</nav> */}
<nav class="navbar navbar-expand-lg navbar-dark">

  
  {/* <div class="col-3"> */}  
									<a href="/">
										<div class="logo">
											<img src="/images/logo2.png" alt="logo" />
										</div>
									</a>
								{/* </div> */}


  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto"></ul>
    <form class="form-inline my-2 my-lg-0 mx-auto">
      <div class="input-group">
        <input class="form-control rounded" type="search" placeholder="Search" aria-label="Search" />
        <div class="input-group-append">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </div>
      </div>
    </form>

    <div class="ml-auto mr-1">
    <a href="/login">
      <button type="button" class="btn btn-danger" >Login</button>
      </a>
      <a href="/register">
      <button type="button" class="btn btn-danger">Register</button>
      </a>
    </div>
  </div>
</nav>
		</>
    );
};

export default Navbar;