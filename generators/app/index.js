var Generator = require('yeoman-generator');

module.exports = class extends Generator {
    
    prompting() {
        var done = this.async();
        return this.prompt([{
            type: 'input',
            name: 'company',
            message: 'Your company name',
            default: 'example'
        },
        {
            type: 'input',
            name: 'name',
            message: 'Your project name',
            default: 'Catalogos'
        },
        {
            type: 'input',
            name: 'port',
            message: 'Which port your service listen',
            default: '8090'
        }]).then(((answers) => {
            this.props = answers;
            this.log('Company:', answers.company);
            this.log('Port:', answers.port);
            this.log('Name:', answers.name);
            done();
        }).bind(this));
    }

    writing() {
        var done = this.async();
        this.fs.copy(
            this.templatePath('.*'),
            this.destinationPath(`${this.props.name.toLowerCase()}-service/`)
        );
        this.fs.copyTpl(
            this.templatePath('**'),
            this.destinationPath(`${this.props.name.toLowerCase()}-service/`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase(),
                port: this.props.port,
                company: this.props.company
            }
        );
        this.fs.copyTpl(
            this.templatePath('*/**/*'),
            this.destinationPath(`${this.props.name.toLowerCase()}-service/`), {
                titleName: this.props.name,
                lowerName: this.props.name.toLowerCase(),
                port: this.props.port,
                company: this.props.company
            }
        );
        done();
    }

    install() {
        var done = this.async();
        this.spawnCommand('mvn',['clean', 'compile', 'test'], {'cwd':`${this.props.name}-Service/`})
        .on('error', function(err) {
            done(err);
        })
    }

};