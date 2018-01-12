var DirectionTypes = {
    DIR0: 0,
    DIR1: 0.785,
    DIR2: 1.57,
    DIR3: 2.355,
    DIR4: 3.14,
    DIR5: 3.925,
    DIR6: 4.71,
    DIR7: 5.495
}

var bullets = []

this.timer = setInterval(moveBullets, 17)

function moveBullets() {
    bullets.forEach((bullet) => bullet.tick())
}


class Bullet {

    constructor(obj, babylonObject) {
        this.id = baby.getCounter()
        this.sBullet = obj
        this.bBullet = babylonObject

        this.bBullet.position.x = obj.x
        this.bBullet.position.y = obj.y
        this.bBullet.position.z = obj.z
        this.bBullet.rotation.y = obj.rotation + Math.PI

    }



    tick() {

        if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR0)) {
            this.bBullet.position.z = (this.bBullet.position.z + (this.sBullet.speed))

        } else if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR1)) {
            this.bBullet.position.x = (this.bBullet.position.x + (this.sBullet.diagonalspeed))
            this.bBullet.position.z = (this.bBullet.position.z + (this.sBullet.diagonalspeed))

        } else if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR2)) {
            this.bBullet.position.x = (this.bBullet.position.x + (this.sBullet.speed))

        } else if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR3)) {
            this.bBullet.position.x = (this.bBullet.position.x + (this.sBullet.diagonalspeed))
            this.bBullet.position.z = (this.bBullet.position.z - (this.sBullet.diagonalspeed))

        } else if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR4)) {
            this.bBullet.position.z = (this.bBullet.position.z - (this.sBullet.speed))

        } else if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR5)) {
            this.bBullet.position.x = (this.bBullet.position.x - (this.sBullet.diagonalspeed))
            this.bBullet.position.z = (this.bBullet.position.z - (this.sBullet.diagonalspeed))

        } else if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR6)) {
            this.bBullet.position.x = (this.bBullet.position.x - (this.sBullet.speed))

        } else if (this.sBullet.direction == 1 && this.sBullet.rotation == (DirectionTypes.DIR7)) {
            this.bBullet.position.x = (this.bBullet.position.x - (this.sBullet.diagonalspeed))
            this.bBullet.position.z = (this.bBullet.position.z + (this.sBullet.diagonalspeed))

        } else {
            console.log("Arrrghg")
        }
    }

}