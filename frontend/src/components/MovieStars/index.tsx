import { ReactComponent as StarFull } from 'assets/img/fullstar.svg';
import { ReactComponent as StarHalf } from 'assets/img/halfstar.svg';
import { ReactComponent as StarEmpty } from 'assets/img/emptystar.svg';
import './styles.css';


function MovieStars() {


    return (
        <div className="dsmovie-stars-container">
            <StarFull />
            <StarFull />
            <StarFull />
            <StarHalf />
            <StarEmpty />
        </div>
    );
}

export default MovieStars;