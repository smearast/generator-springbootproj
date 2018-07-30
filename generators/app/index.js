var Generator = require('yeoman-generator');

module.exports = class extends Generator {
    
    prompting() {
        var done = this.async();
        return this.prompt([{
            type: 'input',
            name: 'name',
            message: 'Your project name',
            default: 'Catalogos'
        }]).then(((answers) => {
            this.props = answers;
            this.log('Name:', answers.name);
            done();
        }).bind(this));
    }

    writing() {
        var done = this.async();
        this.fs.copyTpl(
            this.templatePath('pom.xml'),
            this.destinationPath(`${this.props.name}-Service/pom.xml`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase()
            }
        );

        this.fs.copy(
            this.templatePath('.gitignore'),
            this.destinationPath(`${this.props.name}-Service/.gitignore`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase()
            }
        );

        this.fs.copyTpl(
            this.templatePath('project-web/**/*'),
            this.destinationPath(`${this.props.name}-Service/${this.props.name.toLowerCase()}-web/`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase()
            }
        );

        this.fs.copyTpl(
            this.templatePath('project-services/**/*'),
            this.destinationPath(`${this.props.name}-Service/${this.props.name.toLowerCase()}-services/`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase()
            }
        );

        this.fs.copyTpl(
            this.templatePath('project-persistence/**/*'),
            this.destinationPath(`${this.props.name}-Service/${this.props.name.toLowerCase()}-persistence/`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase()
            }
        );

        this.fs.copyTpl(
            this.templatePath('project-model/**/*'),
            this.destinationPath(`${this.props.name}-Service/${this.props.name.toLowerCase()}-model/`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase()
            }
        );

        this.fs.copyTpl(
            this.templatePath('project-commons/**/*'),
            this.destinationPath(`${this.props.name}-Service/${this.props.name.toLowerCase()}-commons/`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase()
            }
        );
        done();
    }

    /*install() {
        var done = this.async();
        this.spawnCommand('mvn',['clean', 'compile'])
        .on('error', function(err) {
            done(err);
        })
    }*/

};