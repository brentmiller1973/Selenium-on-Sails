importClass(java.io.File);
importClass(java.io.FileNotFoundException);
importClass(java.io.IOException);
importClass(java.util.Scanner);
importClass(java.io.BufferedWriter);
importClass(java.io.FileWriter);
importClass(java.lang.System);

var tools = {
    isSingleFile:false
};

tools.getPathSeperator = function(){
    return String(System.getProperty("file.separator"));
};

tools.directoryListing = function(strDir) {
    var dir = new File(strDir);
    if(dir.isDirectory()){
        tools.isSingleFile = false;
        return dir.list();
    }else{
        tools.isSingleFile = true;
        var _files = new Array(1);
        _files[0] = strDir;
        return _files;
    }

};

tools.getFileNameWithOutExt = function(strFilePath) {

    var file = new File(strFilePath);
    var name = null;
    var index = file.getName().lastIndexOf('.');
    if (index > 0 && index <= file.getName().length() - 2 ) {
        name = file.getName().substring(0, index);
    }else{
        name = file.getName();
    }
    return name;
};

tools.fileReader = function(filePath) {
    var contents = "";

    try {
        contents = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
    } catch (e) {
        e.printStackTrace();
    }

    return String(contents);
};

tools.fileWriter = function(source, fileName) {
    try {
        var out = new BufferedWriter(new FileWriter(fileName));
        out.write(source);
        out.close();
    } catch (e) {
    }
};

tools.deleteDir = function(directory) {
    var dir = new File(directory);
    if (dir.isDirectory()) {
        var children = dir.list();
        for (var i = 0; i < children.length; i++) {
            var success = deleteDir(new File(dir, children[i]));
            if (!success) {
                return false;
            }
        }
    }
    // The directory is now empty so delete it
    return dir.delete();
};


/**
 inspect : A debug utility function to inspect an object
 *
 * @param obj Object to inspect
 * @param maxLevels Optional. Number of levels you will inspect inside the object. Default MaxLevels=1
 * @param level RESERVED for internal use of the function
 * @return {String}
 */

tools.inspect = function(obj, maxLevels, level) {
    var str = '', type, msg;

    // Start Input Validations
    // Don't touch, we start iterating at level zero
    if (level == null)  level = 0;

    // At least you want to show the first level
    if (maxLevels == null) maxLevels = 1;
    if (maxLevels < 1)
        return 'Error: Levels number must be > 0\n';

    // We start with a non null object
    if (obj == null)
        return 'Error: Object is NULL\n';
    // End Input Validations

    // Start iterations for all objects in obj
    for (var property in obj) {
        try {
            // Show "property" and "type property"
            type = typeof(obj[property]);

            str += ' (' + type + ') ' + property;

            if (obj[property] == null) {
                str += ': null\n';
            } else if (typeof(obj[property]) == "string" || typeof(obj[property]) == "number") {
                str += (': ' + obj[property]) + '\n';
            }

            // We keep iterating if this property is an Object, non null
            // and we are inside the required number of levels
            if ((type == 'object') && (obj[property] != null) && (level + 1 < maxLevels))
                str += '\n\n' + inspect(obj[property], maxLevels, level + 1);
        }
        catch (err) {
            // Is there some properties in obj we can't access? Print it red.
            if (typeof(err) == 'string') msg = err;
            else if (err.message)        msg = err.message;
            else if (err.description)    msg = err.description;
            else                        msg = 'Unknown';

            str += '\n(Error) ' + property + ': ' + msg + '\n';
        }
    }

    str += '\n\n\n\n';

    return str;
};