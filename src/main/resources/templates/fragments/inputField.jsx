import React from 'react';
import PropTypes from 'prop-types';

const InputField = ({ label, name, type, hasErrors }) => {
  const valid = !hasErrors(name);

  return (
    <div className={`form-group${valid ? '' : ' has-error'}`}>
      <label className="col-sm-2 control-label">{label}</label>
      <div className="col-sm-10">
        {type === 'text' && (
          <input className="form-control" type="text" name={name} />
        )}
        {type === 'date' && (
          <input className="form-control" type="date" name={name} />
        )}
        {valid ? (
          <span className="fa fa-ok form-control-feedback" aria-hidden="true"></span>
        ) : (
          <>
            <span className="fa fa-remove form-control-feedback" aria-hidden="true"></span>
            <span className="help-inline">Error</span>
          </>
        )}
      </div>
    </div>
  );
};

InputField.propTypes = {
  label: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  type: PropTypes.string.isRequired,
  hasErrors: PropTypes.func.isRequired,
};

export default InputField;
