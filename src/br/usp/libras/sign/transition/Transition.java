package br.usp.libras.sign.transition;

import br.usp.libras.sign.movement.Speed;

public class Transition {

    private Path path = Path.LINEAR;

    private Speed speed = Speed.NORMAL;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((path == null) ? 0 : path.hashCode());
        result = prime * result + ((speed == null) ? 0 : speed.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transition other = (Transition) obj;
        if (path != other.path)
            return false;
        if (speed != other.speed)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Transition [path=");
        builder.append(path);
        builder.append(", speed=");
        builder.append(speed);
        builder.append("]");
        return builder.toString();
    }

}
