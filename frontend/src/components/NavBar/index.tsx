import { ReactComponent as GithubIcon } from 'assets/img/github.svg';
import './styles.css';

function NavBar() {

    return (
        <header>
            <nav className="container">
                <div className="dsmovies-nav-content">
                    <h1> DSMovies </h1>
                    <a href="https://github.com/HigorCampelo">
                        <div className="dsmovies-contact-content">
                            <GithubIcon />
                            <p className="dsmovies-contact-link">/HigorCampelo</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default NavBar;